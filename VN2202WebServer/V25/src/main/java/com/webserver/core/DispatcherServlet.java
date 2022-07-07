package com.webserver.core;

import com.webserver.annotation.Controller;
import com.webserver.annotation.RequestMapping;
import com.webserver.controller.ArticleController;
import com.webserver.controller.UserController;
import com.webserver.http.HttpContext;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理请求的环节
 */
public class DispatcherServlet {
    private static File staticDir;
    static{//静态属于类,当类加载时,会立即加载,并只加载一次
        /*
         * ClientHandler.class.getClassLoader().getResource这种方式./表示
         * target/classes目录
         * 临时测试:将resources目录下static/myweb/index.html响应给浏览器
         * 实际开发中,我们常用的相对路径都是类的加载路径,对应写法:
         * 类名.class..getClassLoader().getResource("./)
         * 这里的./当前目录指的是类加载路径的开始目录,他的实际位置JVM理解就是当前类的包名,
         * 指定中最上级包的上一级.
         * 比如我们ClientHandler,包名是com.webserver.core.
         * 那么包的最上级就是com,com的上一级是target/classes
         *
         */
        try {
            staticDir = new File(
                    ClientHandler.class.getClassLoader().getResource(
                            "./static"
                    ).toURI()
            );
        } catch (URISyntaxException e) {//静态代码块中有异常只能自己处理
            e.printStackTrace();
        }
    }
    public void service(HttpServletRequest request, HttpServletResponse response){
        /*
         * http://localhost:8088/myweb/index.html 访问index页面
         *  抽象路径是:/myweb/index.html
         * http://localhost:8088/myweb/classTable.html 访问classTable页面
         *  抽象路径是:/myweb/classTable.html
         * 所以可以利用抽象路径来确定我们真实访问的页面路径
         */
        String path = request.getRequestURI();
        System.out.println("抽象路径:"+path);
        //判断请求是都是一个业务请求
        try {
            File dir = new File(
                    DispatcherServlet.class.getClassLoader().getResource("./com/webserver/controller").toURI()
            );
            File[] files = dir.listFiles(f->f.getName().endsWith(".class"));
            for (File file : files) {
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.indexOf("."));
                Class cls = Class.forName("com.webserver.controller."+className);
                if (cls.isAnnotationPresent(Controller.class)){
                    Method[] methods = cls.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)){
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            String annotationValue = requestMapping.value();
                            if (annotationValue.equals(path)){
                                Object o = cls.newInstance();
                                method.invoke(o,request,response);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            System.out.println("开始定位静态资源");
            /*
             * 指定父级目录,再指定其中的子集目录
             * 此构造方法的功能:如果path路径错误,不会报空指针了,会自动去指定的父目录
             * 找到指定的子文件,如果文件存在就将文件对象返回,否则就会告知没有这个文件
             */
            File file = new File(staticDir, path);
            //判断是否为文件
            if (file.isFile()){//如果是文件,说明访问的资源存在
                response.setContentFile(file);
            }else{//如果不是文件,说明访问的资源不存在
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                //如果不存在,就访问404页面
                file = new File(staticDir,"/root/404.html");
                response.setContentFile(file);
            }
        }
}

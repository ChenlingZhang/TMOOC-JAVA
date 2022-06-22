package Part08_reflect;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

/**
 * 自动调用当前类Test2 在同一个包下所有的类，方法名含有s的无参公开方法
 */
public class Test02 {
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 定位Test2所在的目录
        File dir = new File(Test02.class.getResource(".").toURI());

        // 过滤出此目录后缀为.class的文件
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for (File sub : subs) {
            String fileName = sub.getName();
            String className = fileName.substring(0,fileName.indexOf("."));
            String packageName = Test02.class.getPackage().getName();
            Class cls = Class.forName(packageName+"."+className);
            Object o = cls.newInstance();
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().contains("s")&&method.getParameterCount()==0&&method.getModifiers()== Modifier.PUBLIC){
                    System.out.println("自动调用Function: " + method.getName());
                    method.invoke(o);
                }
            }
        }
    }
}

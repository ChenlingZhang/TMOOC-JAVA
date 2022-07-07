package com.webserver.controller;

import com.webserver.annotation.Controller;
import com.webserver.annotation.RequestMapping;
import com.webserver.core.ClientHandler;
import com.webserver.entity.User;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理与用户相关的业务操作
 * MVC模型
 * M:model模型
 * V:view视图
 * C:controller
 */

@Controller
public class UserController {
    /*
     * 该目录适用于存储所有用户信息的
     */
    private static File USER_DIR = new File("./users");

    static {
        if (!USER_DIR.exists()) {//判断users目录如果不存在
            USER_DIR.mkdirs();//创建users目录
        }
    }

    /*
     * 处理用户注册
     * request 封装服务器解析好的请求信息
     * response封装返回给浏览器的响应信息
     */
    @RequestMapping("/myweb/reg")
    public void reg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户注册...");
        //1.获取用户表单提交的数据
        String username = request.getParameters("username");
        String password = request.getParameters("password");
        String nickname = request.getParameters("nickname");
        String ageStr = request.getParameters("age");
        System.out.println(username + "," + password + "," + nickname + "," + ageStr);
        if (username == null || password == null || nickname == null
                || ageStr == null || !ageStr.matches("[0-9]+")) {
            //File file = new File(staticDir, "/myweb/reg_fail.html");
            //response.setContentFile(file);
            response.sendRedirect("/myweb/reg_fail.html");
            //注册失败了,就不需要实例化用户信息了,所以直接停止向下执行
            return;
        }
        //2.将用户信息以一个User对象实例形式表示,并序列化到文件中
        int age = Integer.parseInt(ageStr);
        User user = new User(username, password, nickname, age);
        //将要注册的用户信息以用户名.obj的文件的形式保存到users目录中
        File userFile = new File(USER_DIR, username + ".obj");
        //判断用户是否重复
        if (userFile.exists()) {
            //File file = new File(staticDir, "/myweb/reg_have_user.html");
            //response.setContentFile(file);
            response.sendRedirect("/myweb/reg_have_user.html");
            return;
        }
        try (
                FileOutputStream fos = new FileOutputStream(userFile);
                //为了方便的写对象,串联一个对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
            //注册成功了
            //File file = new File(staticDir, "/myweb/reg_success.html");
            //response.setContentFile(file);
            response.sendRedirect("/myweb/reg_success.html");
        } catch (IOException e) {

        }
        System.out.println("处理用户注册完毕...");
    }

    /*
     * 处理用户登陆
     */
    @RequestMapping("/myweb/login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户登陆...");
        String username = request.getParameters("username");
        String password = request.getParameters("password");
        System.out.println(username + "," + password);
        if (username == null || password == null) {
            //File file = new File(staticDir, "/myweb/login_info_error.html");
           //response.setContentFile(file);
            response.sendRedirect("/myweb/login_info_error.html");
            return;
        }
        File userFile = new File(USER_DIR, username + ".obj");
        if (userFile.exists()) {//userFile文件存在,说明用户已经注册
            //反序列化该注册用户信息
            try (
                    FileInputStream fis = new FileInputStream(userFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
                User user = (User) ois.readObject();
                //如果用户登陆时输入的密码和注册时写入的密码相同
                if (user.getPassword().equals(password)) {
                    //登陆成功
                    //File file = new File(staticDir, "/myweb/login_success.html");
                    //response.setContentFile(file);
                    response.sendRedirect("/myweb/login_success.html");
                    return;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //只要登录不成功,一定会走到此处,说明用户名或者密码有错误
        //File file = new File(staticDir, "/myweb/login_fail.html");
        //response.setContentFile(file);
        response.sendRedirect("/myweb/login_fail.html");
        System.out.println("处理用户登陆完毕!");
    }

    /*
     * 生成显示所有用户信息的动态页面
     * 启动服务器,点击首页的用户列表,查看项目下是否出现userList.html页面,
     * 页面里是否有我们写入的页面的代码
     */
    @RequestMapping("/myweb/showAllUser")
    public void showAllUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始生成动态页面...");
        //1.将users目录下的所有obj文件进行反序列化,并将得到的所有User对象存入到List集合中备用
        List<User> userList = new ArrayList<>();
        //listFiles() 获取所有目录里的子元素
        //listFiles(过滤器对象)
        //获取user下所有的文件后缀为.obj文件
        File[] subs = USER_DIR.listFiles(f -> f.getName().endsWith(".obj"));
        //遍历每个obj文件,并进行反序列化得到对应的user对象
        for (File userFile : subs) {
            //将userFile反序列化成User对象
            try (
                    FileInputStream fis = new FileInputStream(userFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
                User user = (User) ois.readObject();
                //将User对象装进userList中
                userList.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //2.生成页面
        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang = \"en\">");
        pw.println("<head>");
        pw.println("<meta charset = \"UTF-8\">");
        pw.println("<title>用户列表</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<center>");
        pw.println("<h1> 用户列表 </h1>");
        pw.println("<table border = \"1\">");
        pw.println("<tr>");
        pw.println("<td>用户名</td>");
        pw.println("<td>密码</td>");
        pw.println("<td>昵称</td>");
        pw.println("<td>年龄</td>");
        pw.println("</tr>");
        for (User user : userList) {
            pw.println("<tr>");
            pw.println("<td>" + user.getUsername() + "</td>");
            pw.println("<td>" + user.getPassword() + "</td>");
            pw.println("<td>" + user.getNickname() + "</td>");
            pw.println("<td>" + user.getAge() + "</td>");
            pw.println("</tr>");
        }
        pw.println("</table>");
        pw.println("</center>");
        pw.println("</body>");
        pw.println("</html>");
        //response.setContentFile(file);
        //设置正文类型Content-Type
        response.setContentType("text/html");
        System.out.println("动态页面生成完毕!!!");
    }
}

package Controller;

import Entity.User;
import core.ClientHandle;
import http.HTTPServletRequest;
import http.HttpServletResponse;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static File USER_DIR = new File("./users");
    private static File STATIC_DIR;
    static {
        if (!USER_DIR.exists()) {
            USER_DIR.mkdirs(); // 创建users目录
        }
        try{
            STATIC_DIR = new File(ClientHandle.class.getClassLoader().getResource("./static").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理用户注册
     */
    public void reg(HTTPServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户注册");
        // 1. 获取用户表单的数据
        String username = request.getParameters("username");
        String password = request.getParameters("password");
        String nickName = request.getParameters("nickname");
        String strAge = request.getParameters("age");
        System.out.println(username + ", " + password + ", " + nickName + ", " + strAge);
        if (username == null || password == null || nickName == null || strAge == null || !strAge.matches("[0-9]+")){
            File file = new File(STATIC_DIR, "MyWeb/reg_fail.html");
            response.setContentFile(file);
            return;
        }
        //2. 将用户信息以一个User对象实例形式表示，并序列化到文件中
        int age = Integer.parseInt(strAge);
        User user = new User(username, password, nickName, age);
        File objectFile = new File(USER_DIR, username + ".obj");
        if (objectFile.exists()){
            File file = new File(STATIC_DIR, "/MyWeb/reg_have_user.html");
            response.setContentFile(file);
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(objectFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(user);
            System.out.println("注册成功");

            File file = new File(STATIC_DIR, "/MyWeb/reg_success.html");
            response.setContentFile(file);
        } catch (IOException e) {
        }
        System.out.println("处理用户完毕");
    }

    public void login(HTTPServletRequest request, HttpServletResponse response){
        String username = request.getParameters("username");
        String password = request.getParameters("password");
        if (username == null || password == null){
            File file = new File(STATIC_DIR, "/MyWeb/login_info_error.html");
            response.setContentFile(file);
            return;
        }
        File userFile = new File(USER_DIR, username+".obj");
        if (userFile.exists()){
            try(FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);){
                User user = (User) ois.readObject();
                if (user.getPassword().equals(password)){
                    File file = new File(STATIC_DIR, "/MyWeb/login_success.html");
                    response.setContentFile(file);
                    return;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            File file = new File(STATIC_DIR, "/MyWeb/login_fail.html");
            response.setContentFile(file);
        }
    }

    /**
     * 生成显示所有用户信息的动态页面
     * @param request
     * @param response
     */
    public void showAllUser(HTTPServletRequest request, HttpServletResponse response){
        System.out.println("开始生成动态页面...");
        List<User> userList = new ArrayList<>();
        File[] subFile = USER_DIR.listFiles(f-> f.getName().endsWith(".obj"));
        for (File file : subFile) {
            try(FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)){
                User user = (User) ois.readObject();
                userList.add(user);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        // 页面生成
        File file = new File("./userList.html");
        try(PrintWriter pw = new PrintWriter(file, "UTF-8");){
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"en\">");
            pw.println("<head>");
            pw.println("<meta charset=\"UTF-8\">");
            pw.println("<title>用户列表</title>");
            pw.println("</head>");
            pw.println("<body>");
            pw.println("<center>");
            pw.println("<h1>用户列表</h1>");
            pw.println("<table border=\"1\">");
            pw.println("<tr>");
            pw.println("<td>用户名</td>");
            pw.println("<td>密码</td>");
            pw.println("<td>年龄</td>");
            pw.println("<td>昵称</td>");
            pw.println("</tr>");
            for (User user : userList) {
                pw.println("<tr>");
                pw.println("<td>"+user.getUsername()+"</td>");
                pw.println("<td>"+user.getPassword()+"</td>");
                pw.println("<td>"+user.getAge()+"</td>");
                pw.println("<td>"+user.getNickname()+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            pw.println("</center>");
            pw.println("</body>");
            pw.println("</html>");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.setContentFile(file);
        System.out.println("动态页面生成结束...");
    }
}

package Controller;

import Entity.User;
import core.ClientHandle;
import http.HTTPServletRequest;
import http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;

public class UserController {
    private static File USER_DIR = new File("./users");
    private static File STATIC_DIR;
    static {
        if (!USER_DIR.exists()) {
            USER_DIR.mkdirs(); // 创建users目录
            System.out.println("new Directory create");
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
}

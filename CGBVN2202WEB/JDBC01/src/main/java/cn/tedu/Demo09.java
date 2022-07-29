package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo09 {
    //注册：用户名，密码，昵称
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String userName = in.nextLine();
        System.out.println("请输入密码: ");
        String password = in.nextLine();
        System.out.println("请输入昵称: ");
        String nickName = in.nextLine();
        try(Connection connection = DBUtil.getConn()){
            String addUser = "insert into user(username,password,nick) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(addUser);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,nickName);
            if (preparedStatement.executeUpdate() > 0){
                System.out.println("执行完毕");
            }
        }catch (SQLException e){

        }
    }
}

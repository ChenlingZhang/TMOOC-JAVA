package cn.tedu;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入用户名: ");
        String userName = in.nextLine();
        System.out.println("请输入密码: ");
        String password = in.nextLine();
        try(Connection connection = DBUtil.getConn()){
            String sql = "select count(*) from user where username = ? and password = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,password);
            ResultSet set = statement.executeQuery();
            set.next();
            int count = set.getInt(1);
            if (count > 0){
                System.out.println("登陆成功");
            }
            else{
                System.out.println("用户名或密码错误");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

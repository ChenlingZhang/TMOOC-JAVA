package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Please Enter UserName: ");
        String username = in.nextLine();
        System.out.println("Please Enter Password: ");
        String password = in.nextLine();
        System.out.println("Please Enter nickname: ");
        String nickname = in.nextLine();

        try(Connection connection = DBUtil.getConn()){
            String sql = "select count(*) from user where username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet set = statement.executeQuery();
            set.next();
            int count = set.getInt(1);
            if (count != 0){
                System.out.println("用户名已存在");
            }else{
                String sql1 = "insert into user(username,password,nick) values(?,?,?);";
                PreparedStatement statement1 = connection.prepareStatement(sql1);
                statement1.setString(1,username);
                statement1.setString(2,password);
                statement1.setString(3,nickname);
                int result = statement1.executeUpdate();
                if (result >0 ){
                    System.out.println("注册成功！");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

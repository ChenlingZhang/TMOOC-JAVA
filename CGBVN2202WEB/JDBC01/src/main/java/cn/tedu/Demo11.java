package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter User Name: ");
        String username = scanner.nextLine();
        System.out.println("Please Enter Password: ");
        String password = scanner.nextLine();

        try(Connection connection = DBUtil.getConn()){
            Statement statement = connection.createStatement();
            String sql = "select * from user";
            ResultSet set = statement.executeQuery(sql);
            HashMap<String, String> userMap = new HashMap<>();
            while(set.next()){
                userMap.put(set.getString("username"),set.getString("password"));
            }
            if (userMap.containsKey(username)){
                if (userMap.get(username).equals(password)){
                    System.out.println("登陆成功");
                }
                else{
                    System.out.println("密码错误");
                }
            }
            else{
                System.out.println("用户名错误");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

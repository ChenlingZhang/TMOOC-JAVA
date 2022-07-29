package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a Hero Name");
        String heroName = scanner.nextLine();
        System.out.println("Please Enter a Hero Price: ");
        double money = scanner.nextDouble();
        try(Connection connection = DBUtil.getConn()){
            String addHero = "insert into hero(name, money) values(?,?);";
            PreparedStatement statement = connection.prepareStatement(addHero);
            statement.setString(1,heroName);
            statement.setDouble(2,money);
            statement.executeUpdate();
        }catch (Exception e){

        }
    }
}

package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false","root","Zxy199569");
        Statement statement = connection.createStatement();
        statement.execute("drop table jdbct1");
        connection.close();
    }
}

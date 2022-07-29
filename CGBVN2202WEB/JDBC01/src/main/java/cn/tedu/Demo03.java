package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false","root","Zxy199569");
        Statement statement = connection.createStatement();
        //String insertTable = "insert into jdbct1 values('Tom')";
        //String change = "update jdbct1 set name='Jerry' where name='Tom'";
        String delete = "delete from jdbct1 where name='Jerry'";
        statement.executeUpdate(delete);
        connection.close();
    }
}

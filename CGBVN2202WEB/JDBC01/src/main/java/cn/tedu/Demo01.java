package cn.tedu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        // 1. 获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai","root","Zxy199569");
        System.out.println("Connection: " + connection);
        // 2. 创建执行SQL语句对象
        Statement statement = connection.createStatement();
        // 3. 执行SQL语句
        statement.execute("create table jdbct1(name varchar (20))");
        connection.commit();
        // 4. 关闭连接
        connection.close();
        System.out.println("创建完成");
    }
}

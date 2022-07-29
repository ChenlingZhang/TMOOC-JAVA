package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static DruidDataSource druid;
    static {
        druid = new DruidDataSource();
        druid.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&setSSL=false");
        druid.setUsername("root");
        druid.setPassword("Zxy199569");
        // 设置初始连接数量
        druid.setInitialSize(3);
        // 设置最大的连接数量
        druid.setMaxActive(5);
    }
    public static Connection getConn() throws SQLException {
        // 从连接池中获取连接
        Connection connection = druid.getConnection();
        System.out.println("连接对象：" + connection);
        return connection;
    }
}

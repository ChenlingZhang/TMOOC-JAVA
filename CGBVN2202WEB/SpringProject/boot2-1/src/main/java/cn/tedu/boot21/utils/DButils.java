package cn.tedu.boot21.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DButils {
    private static DruidDataSource ds;
    static {
        ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("Zxy199569");
        ds.setInitialSize(3);
        ds.setMaxActive(5);
    }

    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }
}

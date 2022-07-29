package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        try(Connection connection = DBUtil.getConn()) {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) throws SQLException {
        try(Connection connection = DBUtil.getConn()){
            Statement statement = connection.createStatement();
            String tableCreate = "create table hero(id int primary key auto_increment, name varchar(50), money double)";
            statement.execute(tableCreate);
        }
    }
}

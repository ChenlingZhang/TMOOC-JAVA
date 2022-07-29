package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo07 {
    public static void main(String[] args) {
        try(Connection connection = DBUtil.getConn()){
            Statement statement = connection.createStatement();
            String getEntity = "select * from hero";
            ResultSet set = statement.executeQuery(getEntity);
            while (set.next()){
                System.out.println("Hero Name: " + set.getString(1));
                System.out.println("Hero Name: " + set.getString(2));
                System.out.println("Hero Price: " + set.getDouble(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

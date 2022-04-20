package ObjectCT;

import java.util.ArrayList;

public class PointDemo {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        System.out.println("普通调用X: " + point.getX());
        System.out.println("普通调用Y: " +point.getY());

        // toString 功能可以直接显示对象的数据信息
        String info = point.toString();
        System.out.println("toString 显示: "+ info);
        // 直接调用
        System.out.println(point);



    }
}

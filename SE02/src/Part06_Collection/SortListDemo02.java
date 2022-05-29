package Part06_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo02 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(15,66));
        list.add(new Point(7,8));
        list.add(new Point(13,55));
        System.out.println(list);
        /**
         * sort方法对排序的集合有要求，要求集合元素必须实现了Comparable接口，
         * 实现了该接口的类型，并且重写一个方法compareTo方法用于定义比较大小的规则
         * 从而进行元素间的比较进行排序，否则编译不通过
         */
        // 使用匿名内部类的方式创建一个比较器，可以使用范型约束我们比较的两个point
        Comparator<Point> compare = new Comparator<Point>() {
            // 实现比较器之后必须要重写方法compare
            // 该方法用来定义参数o1和参数o2的比较大小规则
            // 返回值用来表示o1和o2之间的大小关系
            @Override
            public int compare(Point o1, Point o2) {
                //点与点比较一般都是距离原点的距离越远越大
                int distance_o1 = (int)(Math.sqrt(Math.pow(o1.getX(),2)+Math.pow(o1.getY(),2)));
                int distance_o2 = (int) (Math.sqrt(Math.pow(o2.getX(),2) + Math.pow(o2.getY(),2)));
                return distance_o1-distance_o2;
            }
        };
        Collections.sort(list,compare);
        System.out.println(list);
    }
}

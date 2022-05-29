package Part06_Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo04 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1: " + c1);
        Collection c2 = new ArrayList();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2: "+ c2);
        c1.addAll(c2); // 将给定的元素全部添加到当前的集合中，取并集
        System.out.println(c1);

        Collection c3 = new ArrayList();
        c3.add("c++");
        c3.add("java");
        c3.add("php");
        boolean b = c1.containsAll(c3);
        System.out.println("Contains all c3 in c1： " + b);
        /**
         * contains all 判断当前集合是否包含目标集合中的所有元素
         * 取交集
         */

        /**
         * 删除交集
         */
        c1.removeAll(c3);
        System.out.println(c1);
        System.out.println(c3);
    }
}

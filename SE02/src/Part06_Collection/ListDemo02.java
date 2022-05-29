package Part06_Collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /**
         * void add(int index, E e)
         * list中的add方法可以在集合指定位置添加元素
         */
        list.add(3,"six");
        /**
         * E remove（int index）
         */
        String removed = list.remove(2);
        System.out.println(removed);
        System.out.println(list);

    }
}

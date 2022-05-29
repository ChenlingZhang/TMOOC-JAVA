package Part06_Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * java.util.List 接口
 * List继承自Collection，是最常用的一类集合，特点：可以存放重复元素且有序
 * List里提供了一套可以通过下标元素的方法
 * 常用实现类：
 * java.util.Arraylist:内部使用的数组实现，查询性能好
 * java.util.LinkedList: 内部树勇的链表实现，增删性能好，首尾增删性能最佳
 * 对性能没有苛刻要求的情况下，通常还是使用ArrayList
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);

        // 获取集合中的第三个元素
        String str = list.get(3);
        System.out.println("The third element is: " + str);

        for (int i = 0; i < list.size() ; i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        String oldElement = list.set(1,"six");
        System.out.println("Old Elements: " + oldElement);
        System.out.println("New Elements: " + list.get(1));

        /**
         * 在不创建新的集合的情况下，将集合进行反转。
         */
        for (int i = 0; i<list.size()/2; i++){
            String temp = list.get(i);
            temp = list.set(list.size()-1-i,temp );
            list.set(i,temp);
        }
        System.out.println("Reverse List: " + list);
        Collections.reverse(list);
        System.out.println("Utils Revers List: " + list);
    }
}

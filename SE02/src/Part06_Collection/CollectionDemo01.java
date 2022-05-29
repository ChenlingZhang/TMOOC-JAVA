package Part06_Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Java 集合框架
 * 集合和数组是一样的，都是用来存储一组元素，但是集合将元素的操作封装成了方法
 * 并且集合还提供了多种不同的实现供我们使用
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        /**
         * 集合中只能存放引用类型
         */
        Collection c = new ArrayList();
        /**
         * add方法
         */
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

    }
}

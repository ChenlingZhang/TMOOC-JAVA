package Part06_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 * Collection层面不支持随机访问操作（根据指定的位置获取对应的元素）
 * 但是集合支持遍历操作，我们可以通过遍历集合的方式拿到集合中的每一个元素
 * 集合提供了一个统一的遍历方式，即迭代器遍历
 * 对应方法
 * Iterator iterator（）
 * 该方法会返回一个用于遍历当前集合的迭代器
 * java.util.Iterator是迭代器的接口，定义了迭代器遍历集合的基本操作，
 * 所有的集合都提供了一个变量自身的迭代器实现类
 */

public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);
        // 获取迭代器对象；
        Iterator iterator = c.iterator();
        while(iterator.hasNext()){
            String next = (String) iterator.next();
            if (next.equals("#")){
                /**
                 * 迭代器在遍历的过程中，不能通过集合的方法来增删元素，否则迭代器会抛出一场，需要使用迭代器内置的
                 * remove方法，可以将当前的next从集合中移除
                 */
                iterator.remove();
            }
        }
        System.out.println(c);
    }
}

package Part06_Collection;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Map的遍历
 * 1. 单独遍历key
 * 2. 遍历每一组键值对
 */
public class MapDemo02 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Chinese",98);
        map.put("Math",100);
        map.put("English",80);
        map.put("Physics",60);
        map.put("java",150);
        System.out.println(map);
        /**
         * Set keySet()
         * 将当前的map中所有的key以一个set集合的形式返回
         */
        Set<String> keySet = map.keySet();
        for (String  s: keySet) {
            System.out.println("map的key是: " + s);
            System.out.println("map的value是: " + map.get(s));
        }

        /**
         * 获取Map中的每一对键值对
         */
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        for (Map.Entry<String,Integer> entry: entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key: " + key + "=====" + "Value: " + value);
        }

        /**
         * Lambda 表达式简化遍历Map和集合
         */
        map.forEach(
                // 此处K和V起什么名字无所谓，第一个值是key，第二个值是value
                (k,v) -> System.out.println(k+" : " + v)
        );

        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.forEach(
                // 当只有一个参数的时候小括号可以省略
                e-> System.out.println(e)
        );
        // 如果申明的参数和输出的参数都是一个，参数可以省略，并且替换为：：
        c.forEach(
                System.out::println
        );
    }
}

package Part06_Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("语文",80);
        Integer value = map.put("数学",70);
        System.out.println("value: " + value);
        map.put("英文",34);
        map.put("化学",60);
        System.out.println(map);
        value = map.put("数学",150);
        System.out.println("value: " + value);
        System.out.println(map);

        /**
         * V get(Object K)
         * 根据给定的key获取对应的value，如果给定的key不存在返回为Null
         */
        Integer score = map.get("语文");
        System.out.println("语文: " + score);
        score = map.get("体育");
        System.out.println("体育: " + score);

        //返回map中元素的个数
        int size = map.size();
        System.out.println("集合中有"+size+"个元素");
        /**
         * 删除给定的key对应的这组键值对，返回值为这个key对应的value
         */
        score = map.remove("数学");

    }
}

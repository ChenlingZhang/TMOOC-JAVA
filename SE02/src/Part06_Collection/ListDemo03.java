package Part06_Collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo03 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        /**
         * 获取子集 3-7 含头不含尾
         */
        List<Integer> sublist = list.subList(3,8);
        System.out.println(sublist);
    }
}

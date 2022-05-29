package Part06_Collection;

import java.util.*;

public class SortListDemo {
    public static void main(String[] args) {
        List<Integer>list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

package Part06_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionToArrayDemo {
    public static void main(String[] args){
        Collection<String> c = new ArrayList<>();
        c.add("老大");
        c.add("老2");
        c.add("老3");
        c.add("老4");
        c.add("老5");
        c.add("老6");
        System.out.println("Collection: " + c);
        String[] array = c.toArray(new String[c.size()]);
        System.out.println("Array: " + Arrays.toString(array));
    }
}

package Part06_Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println("Array: " + Arrays.toString(array));
        List<String> list = Arrays.asList(array);
        System.out.println("Collection: " + list);
    }
}

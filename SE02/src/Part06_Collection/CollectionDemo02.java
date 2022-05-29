package Part06_Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo02 {
    public static void main(String[] args) {
        Collection<Point> c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,0));
        System.out.println(c);
    }
}

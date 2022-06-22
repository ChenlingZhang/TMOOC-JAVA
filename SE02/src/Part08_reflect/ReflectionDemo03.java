package Part08_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p = new Person("zzzzz",19);
        System.out.println(p);

        Class c = Class.forName("Part08_reflect.Person");
        Constructor constructor = c.getConstructor(String.class,int.class);

        Object object = constructor.newInstance("bbbbb",29);
        System.out.println(object);
    }
}

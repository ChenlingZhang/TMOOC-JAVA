package Part08_reflect;

import java.util.Scanner;

public class ReflectionDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 1. 传统方式实例化对象
        Person p = new Person();
        System.out.println(p);

        //2. 利用反射实例化对象
        Class cls = Class.forName("Part08_reflect.Person");
        Object o = cls.newInstance();
        System.out.println(o);

        Scanner in = new Scanner(System.in);
        String className = in.nextLine();
        Class cls1 = Class.forName(className);
        Object o1 = cls1.newInstance();
        System.out.println("反射方式：" + o1);

    }
}

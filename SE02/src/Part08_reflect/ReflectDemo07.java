package Part08_reflect;

import Part08_reflect.annotation.AutoRunClass;

/**
 * 反射机制使用注解
 */
public class ReflectDemo07 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("Part08_reflect.Person");
        if (cls.isAnnotationPresent(AutoRunClass.class)){
            System.out.println(cls.getSimpleName()+"被 @AutoRunClass标注了");
        }
        else {
            System.out.println(cls.getSimpleName()+"没有被@AutoRunClass标注了");
        }
    }
}

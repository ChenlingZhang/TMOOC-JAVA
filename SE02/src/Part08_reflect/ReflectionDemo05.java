package Part08_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射调用的方法
 */
public class ReflectionDemo05 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("Part08_reflect.Person");
        Object obj = c.newInstance();
        Method method = c.getMethod("doSome", String.class);
        method.invoke(obj,"lalalal");
    }
}

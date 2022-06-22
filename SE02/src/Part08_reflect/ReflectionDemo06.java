package Part08_reflect;

import java.lang.reflect.Method;

/**
 * 以往私有方法在类的外面是不能被访问的
 * 但是利用反射我们可以访问私有方法
 */
public class ReflectionDemo06 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("Part08_reflect.Person");
        Object obj = c.newInstance();
        Method method = c.getDeclaredMethod("secret");
        method.setAccessible(true); // 强行打开访问权限
        method.invoke(obj);
    }
}

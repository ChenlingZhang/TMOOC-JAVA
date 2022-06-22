package Part08_reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用Person类中所有带有"s"的无参公开方法
 */
public class ReflectionDemo {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("Part08_reflect.Person");
        Object obj = cls.newInstance();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount()==0 && method.getName().contains("s")&&method.getModifiers()== Modifier.PUBLIC){
                method.invoke(obj);
            }
        }
    }
}

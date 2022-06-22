package Part08_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用Part08_Reflect.Person中所有带s的方法
 */
public class Test01 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class cls = Class.forName("Part08_reflect.Person");
        Object o = cls.newInstance();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().contains("s")&&method.getParameterCount()==0&&method.getModifiers()== Modifier.PUBLIC){
                System.out.println("自动执行符合条件的方法：" + method.getName());
                method.invoke(o);
            }
        }
    }
}

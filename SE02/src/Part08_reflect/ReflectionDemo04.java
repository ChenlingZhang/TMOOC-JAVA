package Part08_reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 使用反射调用方法
 */
public class ReflectionDemo04 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person person = new Person();
        person.sayGoodBye();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入包名：");
        String className = scanner.nextLine();
        System.out.println("请输入方法名：");
        String methodName = scanner.nextLine();
        Class cls = Class.forName(className);
        Object object = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(object);
    }
}

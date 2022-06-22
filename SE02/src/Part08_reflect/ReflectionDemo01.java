package Part08_reflect;

import java.lang.reflect.Method;

/**
 * 反射是java中的动态机制，它允许我们在程序运行期间在确定对象的实例化，方法的调用，属性的操作等，使得程序的灵活
 * 度大大的提升，但是同时也带来了更多的资源消耗和较低的运行效率
 * 程序不能过度的依赖反射机制
 */
public class ReflectionDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 反射操作第一步，获取需要操作类的类对象，获取一个类对象的方式：
         * 1：类名.class
         *  Class cls = String.class;
         *  Class cls = int.class
         * 2：Class.forName(String className)
         *  使用Class的静态方法传入要加载的类的完全限定名（包名.类名）
         *  Class cls = Class.forName("java.lang.String");
         * 3: ClassLoader 类加载器
         */
        // 获取String的Class对象，这个对象中，包含String的所有信息
        //Class cls = Person.class;
        Class cls = Class.forName("Part08_reflect.Person");
        String name = cls.getName();//获取String类的全限定名（包名+类名）
        System.out.println(name);
        String simpleName = cls.getSimpleName(); //获取字节码文件的类名
        System.out.println(simpleName);
        String packageName = cls.getPackage().getName(); // 获取包名
        System.out.println(packageName);

        // 获取当前对象所表示类的所有的公开方法（包括从超类中继承来的方法）
        Method[] methods = cls.getMethods();
        System.out.println(cls.getSimpleName()+ " 一共有：" + methods.length + " 个公开方法");

        // 获取当前对象所表示类的所有公开的方法
        Method[] allMthods = cls.getDeclaredMethods();
        System.out.println(cls.getSimpleName() + " 一共有：" + allMthods.length + " 个方法");
        int numberOfPrivateMethod = methods.length-allMthods.length;
        System.out.println(cls.getSimpleName() + " 一共有：" + numberOfPrivateMethod + " 个私有方法");
    }
}

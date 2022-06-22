package Part08_reflect;

import Part08_reflect.annotation.AutoRunClass;
import Part08_reflect.annotation.AutoRunMethod;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 自动实例化当前ReflectDemo8同包下所有被@AutoRunClass修饰的类
 */
public class ReflectionDemo08 {
    public static void main(String[] args) throws Exception {
        File dir = new File(ReflectionDemo08.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for (File sub : subs) {
            String filename = sub.getName();
            String className = filename.substring(0,filename.indexOf("."));
            Class cls = Class.forName(ReflectionDemo08.class.getPackage().getName()+"."+className);
            if (cls.isAnnotationPresent(AutoRunClass.class)){
                Object o = cls.newInstance();
                System.out.println(o);
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)){
                        AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                        System.out.println(arm.value());
                        method.invoke(o);
                    }
                }
            }
        }
    }
}

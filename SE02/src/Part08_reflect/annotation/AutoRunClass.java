package Part08_reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    注解是用来标注哪些可以被反射机制自动调用的类
    用来修饰注解的注解被称之为原注解
    定义注解时，我们通常会使用Java内置的两个注解加以修饰，其中
    @Rentention 用来指定当前定义的注解的保留级别，有三个可选值，对应：
        RetentionPolicy.SOURC 表示当前声明的注解仅保留在源码中
        RetentionPolicy.CLASS 表示当前注解会保留在.class文件中，但是反射机制不可用
        RetentionPolicy.RUNTIME 表示保留在.class文件中，但是可以被反射机制使用
        通常我们定义为RUNTIME级别，辅助反射机制的操作
    @Target 用来指定当前定义的注解的使用位置，可选项都定义在ElementType上
    常见值：
    ElementType.Type   在类上使用
    ElementType.FIELD  在属性上使用
    ElementType.METHOD 在方法上使用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 允许使用在类上或方法上
public @interface AutoRunClass {
}

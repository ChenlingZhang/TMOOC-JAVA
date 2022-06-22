package Part08_reflect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoRunMethod {
    /**
     * 为注解添加参数
     * 语法：
     * 类型 参数名（）
     * 注明：如果注解只有一个参数时，通常参数名使用vlaue
     *
     * @return
     */
    int value() default 1; // 不传入值的时候为1
}

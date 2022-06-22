package Part08_reflect;

import java.util.Arrays;

/**
 * JDK 5之后推出一个特性：变长参数
 */
public class ArgsDemo {
    public static void main(String[] args) {
        doSome(1);
        doSome(1,2);

    }

    /**
     * 变长参数必须是方法中的最后一个参数
     * @param age
     */
    public static void doSome(int... age){
        System.out.println(age.length);
        System.out.println(Arrays.toString(age));
    }
}

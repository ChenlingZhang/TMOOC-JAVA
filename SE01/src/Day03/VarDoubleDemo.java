package Day03;

/**
 * double 类型的使用类
 */
public class VarDoubleDemo {
    public static void main(String[] args) {
        double a = 3.1415926; // 申明一个double类型的变量，命名为a，并负值 3.1415926
        double b = 6.999D;   // 可以在浮点数类型后面加上大写的D表示浮点数类型
        double c = 3.0;
        double d = 2.9;
        System.out.println(c - d); // double 类型的数据在进行运算时会存在误差，无限接近0.1

        double c1 = 6.0;
        double c2 = 4.9;
        System.out.println(c1 - c2);

        double d1 = 6.0;
        double d2 = 1.9;
        System.out.println(d1 - d2);

        // 布尔类型案例
        boolean b1 = true;
        boolean b2 = false;
        System.out.println("The Value of B1 is: " + b1);
        System.out.println("The Value of B2 is: " + b2);
    }
}

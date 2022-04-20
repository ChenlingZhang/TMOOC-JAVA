package Day03;

/**
 * 类型转换的演示类：
 */
public class DataTypeDemo {
    public static void main(String[] args) {
        // 自动转换：将小的类型往大的类型赋值的过程
        int a = 5; // 没有发生自动类型转换
        long b = a; //  发生了自动类型转换
        long c = 1000; // 发生了自动类型转换
        double d = c; // 发生了自动类型转换
        int e = 10;
        double dd = e;
        System.out.println(dd);

        // 强制类型转换
        long al = 1000000000L; // 10亿
        int bi = (int)al;// 强制转换的语法，在需要转换类型的变量上面加上（目标类型）

        long cl = 3000000000L;
        int di = (int) cl; //此时会显示溢出值，因为30亿超过了int的最大范围
        System.out.println(di); // 强制类型转换，需要明确知道当前的数据转换成小类型时不会发生数据溢出





    }
}

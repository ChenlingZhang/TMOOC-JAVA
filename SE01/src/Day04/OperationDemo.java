package Day04;

/**
 * 运算符相关演示类
 */

public class OperationDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = a+b;
        System.out.println(c);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(5%2); // 取余

        System.out.println(2%2);
        System.out.println(8%2);
        // 取余操作时，若左边的数据，小于右边的数据，其余数是左边自身的数据
        System.out.println(1%3);
        System.out.println(2%3);
        System.out.println(8%2);


    }
}

package Day06;

public class ForDemo2 {
    /**
     * 双重For循环的嵌套与使用
     * @param args
     */
    public static void main(String[] args) {
        // 9 9 乘法表
        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i + " * " + j + " = " + i*j);
                System.out.print("    ");
            }
            System.out.println(" ");
        }

        // 外层代表行数，内层代表列数
    }
}

package Practice.Demo01;

public class ForDemo {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j <=i ; j++) {
                int result = i*j;
                System.out.print(i + " * " + j + " = " + result + "    ");
            }
            System.out.println(" ");
        }
    }
}

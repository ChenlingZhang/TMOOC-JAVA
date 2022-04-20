package Practice.Demo01;

import java.util.Scanner;

public class IFDemo {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请输入成绩");
        Scanner in = new Scanner(System.in);
        double grade = in.nextDouble();
        if (grade >= 90){
            System.out.println('A');
        }else if (grade >= 70){
            System.out.println('B');
        }else if (grade >= 60){
            System.out.println('C');
        }else {
            System.out.println('D');
        }
    }
}

package HW03;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入今天的天气情况（0：晴，1:阴，2:多云，3: 下雨)");
        int choice = in.nextInt();
        switch (choice){
            case 0:
                System.out.println("打太极拳");
                break;
            case 1:
                System.out.println("爬香山");
                break;
            case 2:
                System.out.println("约会");
                break;
            case 3:
                System.out.println("睡觉");
                break;
        }
    }
}

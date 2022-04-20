package Day06;

import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {
        /**
         * do..while 循环结构
         * do{
         *  ...
         *  } while(boolean)
         */

        // 猜数字
        int guessNum = (int)(Math.random()*(100-0)+0);
        int ansNum = 0;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入一个正整数");
            ansNum = in.nextInt();
            if (guessNum > ansNum){
                System.out.println("你猜的数字太小了");
            }else if (guessNum < ansNum){
                System.out.println("你猜的太大了");
            }else {
                System.out.println("答案正确");
                break;
            }
        }
        while(ansNum != guessNum);

    }
}

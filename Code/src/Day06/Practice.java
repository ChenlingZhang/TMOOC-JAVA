package Day06;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i<=10; i++){
            int addNumA = (int) (Math.random() * 100);
            int addNumB = (int) (Math.random() * 100);
            System.out.println(" ( "+i+" ) "+addNumA+" + " + addNumB + " = " + " ？");
            System.out.println("请输入答案，以回车结束");
            int result = in.nextInt();
            if (result == (addNumA+addNumB)){
                System.out.println("回答正确");
            }
            else{
                System.out.println("回答错误");
            }

        }
    }
}

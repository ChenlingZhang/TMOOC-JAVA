package HomeWork.HomeWork01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ageEnter();
        // play();
        // pig();
        // dayCalculate();
        triangle(5);
    }

    public static void ageEnter(){
        Scanner in = new Scanner(System.in);
        int i = 0;
        System.out.println("请输入5个人的年龄");
        int age = 0;
        int[] agelist = new int[5];
        while(i<5){
            age = in.nextInt();
            if (age < 0 || age>130){
                System.out.println("输入有误，程序终止");
                break;
            }
            else{
                System.out.println("年龄录入");
                agelist[i] = age;
                i++;
            }
        }
        for (int j = 0; j < agelist.length; j++) {
            if (agelist[j] != 0) {
                System.out.println(j + 1 + " 个人的年龄是: " + agelist[j]);
            }
        }
    }
    public static void play(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        boolean isContinue = true;
        while(isContinue){
            System.out.println("输入0，1，2 显示石头剪刀布");
            int userEnter = in.nextInt();
            switch (userEnter){
                case 0:
                    System.out.println("你出的是石头");
                    break;
                case 1:
                    System.out.println("你出的是剪刀");
                    break;
                case 2:
                    System.out.println("你出的是布");
                    break;
                default:
                    System.out.println("你的输入有误");
            }
            System.out.println("输入y继续游戏，输入其他则退出程序");
            String userContinue = in2.nextLine();
            if (!userContinue.equals("y")){
                isContinue = false;
            }

        }
    }
    public static void pig(){
        for (int i = 0; i < 10; i++) {
            int pigId = (int)(Math.random()*3);
            switch (pigId){
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                case 2:
                    System.out.println("生成了一只红猪，有下酒菜了");
                    break;
            }
        }
    }
    public static void dayCalculate(){
        int result = 0;
        for (int i = 2000; i <2008; i++) {
            int day = 365;
            if (i%4==0&&i%100!=0 || i%400==0){
                day = 366;
            }
            result+=day;
        }
        System.out.println(result);
    }
    public static void triangle(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i ; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

package Day05;

import java.util.Scanner;

public class ScoreDemo
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double score = in.nextDouble();
        if (score >= 90){
            System.out.println("优秀！");
        }else if(score >=80){
            System.out.println("良好");
        }else if(score >= 70){
            System.out.println("一般");
        }else if (score >= 60){
            System.out.println("及格");
        }else{
            System.out.println("不及格");
        }

        System.out.println("请输入年龄：");
        int age = in.nextInt();
        if (age>=0 && age<5){
            System.out.println("幼年");
        }else if (age>=5&&age<12){
            System.out.println("少年");
        }else if (age>=12 && age<18){
            System.out.println("青年");
        }else if (age>=18&&age<35){
            System.out.println("成年");
        }else if(age>=35&age<50){
            System.out.println("中年");
        }else if (age>=50&&age<65){
            System.out.println("中老年");
        }else if (age>=65&&age<130){
            System.out.println("老年");
        }else{
            System.out.println("The input is illegel");
        }
    }
}

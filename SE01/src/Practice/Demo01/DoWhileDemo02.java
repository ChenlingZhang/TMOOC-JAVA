package Practice.Demo01;

public class DoWhileDemo02 {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;
            for (int i = 0; i <=100 ; i++) {
                if (i%5!=0||i%7!=0){
                    sum += i;
                    count++;
                    if(sum >300){
                        break;
                    }
                }
            }
        System.out.println("一共有：" + count + " 次循环");
        System.out.println("总和为：" + sum);
    }
}

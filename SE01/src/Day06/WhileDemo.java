package Day06;

public class WhileDemo {
    public static void main(String[] args) {
        int count = 0;
        double path = 0;
        double meter = 100;
        while(meter>0.01){
            count++;
            path += meter;
            meter /=2;
        }
        System.out.println("总共弹起 " + count + " 次");
        System.out.println("总共经过：" + path + " 米");

    }
}

package Day05;

/**
 * if 单路分支的使用演示类
 */
public class IFDemo {
    public static void main(String[] args) {
        /**
         * 语法结构：
         * if（boolean）{
         * }
         */
        double price = 500;
        if (price >= 500){
            System.out.println("最终金额：" + (price*0.8));
        }

        /**
         * 购物满500 打8折 不满打9折
         */
        double price2 = 900;
        if (price2 >= 500){
            price2*=0.8;
            System.out.println("打8折应付："+price2);
        }
        else{
            price2*=0.9;
            System.out.println("打9折后应付款："+(price2*0.9));
        }
        System.out.println("最后付款"+price2);
    }
}

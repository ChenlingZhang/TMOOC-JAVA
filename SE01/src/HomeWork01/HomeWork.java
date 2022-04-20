package HomeWork01;


public class HomeWork {
    public static void main(String[] args) {
        // 第一题
        System.out.println("第一题：编写三个方法，分别得出一个数组的最大值，最小值，平均值");
        int[] numberList = {2,1,3};
        int minNumber = getMinNumber(numberList);
        System.out.println("数组中的最小值为: " + minNumber);
        int maxNumber = getMaxNumber(numberList);
        System.out.println("数组中的最大值为: " + maxNumber);
        double avgNumber = getAvgNumber(numberList);
        System.out.println("数组中的平均值为: " + avgNumber);
        System.out.println(" ");

        // 第二题
        System.out.println("第二题：创建宠物类（属性：名字 ，体重 方法： 奔跑，捕食）在DEMO类实例化宠物，设置名字，调用奔跑，捕食方法");
        Pet pet = new Pet("Tom", 20.0);
        pet.hunt();
        pet.run();

        // 第三题
        System.out.println("第三题: 创建一个面积类，可以计算长方形，圆形的面积。并在DEMO类测试，计算长方形面积，圆的面积。");
        Area rectangle = new Area(20,30);
        Area circle = new Area(50);
        System.out.println("长方形面积为: " + rectangle.rectangleArea(rectangle.getLength(), rectangle.getHeight()));
        System.out.println("圆形面积为: " + circle.circleArea(circle.getLength()));
        System.out.println(" ");

        // 第四题
        System.out.println("第四题: 判断一个数是否是水仙花数");
        int num = 153;
        numberCheck(153);
        System.out.println(" ");
        // 第五题
        System.out.println("第五题: 本息计算器");
        double totalMoney = moneyGain(1000,4);
        System.out.println("本息总和是: " + totalMoney);
        System.out.println(" ");
        // 第六题
        System.out.println("第六题: 个税计算器");
        double salaryAfterTax = taxCalculate(18000);
        System.out.println("税后工资是: " + salaryAfterTax);



    }

    /**
     * @param array
     * @return int
     * 获取一串int数组中的最小值
     */
    public static int getMinNumber(int[] array){
        int tempNum = array[0];
        for (int i = 0; i < array.length ; i++) {
            if (tempNum > array[i]){
                tempNum = array[i];
            }
        }
        return  tempNum;
    }

    /**
     *
     * @param array
     * @return int
     * 获取一串int数组中的最大值
     */
    public static int getMaxNumber(int[] array){
        int tempNum = array[0];
        for (int i = 0; i <array.length ; i++) {
            if (tempNum < array[i]){
                tempNum = array[i];
            }
        }
        return tempNum;
    }

    /**
     *
     * @param array
     * @return double
     * 获取一串int数组的平均值
     */
    public static double getAvgNumber(int[] array){
        int total = 0;
        for (int num: array) {
            total += num;
        }
        return (total/array.length);
    }

    /**
     *
     * @param num
     * 返回这个数字输入的数字是否为水仙花数
     */
    public static void numberCheck(int num){
        if (num <999 & num>99){
            int firstNum = num/100;
            int secondNum = (num%100)/10;
            int thirdNum = num%10;
            int checkedNum = (int) (Math.pow(firstNum,3) + Math.pow(secondNum,3) + Math.pow(thirdNum,3));
            if (checkedNum == num){
                System.out.println(checkedNum + " 这是一个水仙花数");
            }

        }
        else{
            System.out.println("请输入一个三位数");
        }
    }

    /**
     *
     * @param money
     * @param year
     * @return 一定年限后返回的本息总额
     */
    public static double moneyGain(double money, int year){
        double totalMoney = 0;
        switch (year){
            case 1:
                totalMoney = money*1.0225;
                break;
            case 2:
                totalMoney = money*1.027;
                break;
            case 3:
                totalMoney = money*1.0325;
                break;
            case 4:
                totalMoney = money*1.036;
                break;

            default:
                if (year < 1){
                    totalMoney = money*1.0225;
                }
                if (year > 4){
                    totalMoney = money*1.036;
                }
        }
        return totalMoney;

    }

    public static double taxCalculate(double salary){
        double salaryWithoutInsurence = salary-1800;
        double salaryAfterTax = 0;
        if (salaryWithoutInsurence < 5000 ) {
            System.out.println("不足个税起征点！！！");
        }
        else{
            salaryWithoutInsurence = salaryWithoutInsurence-5000;
            if (salaryWithoutInsurence >=0 && salaryWithoutInsurence<=3000){
                salaryAfterTax = salaryWithoutInsurence - (salaryWithoutInsurence*0.03);
            }
            else if (salaryWithoutInsurence > 3000 && salaryWithoutInsurence<=12000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + (salaryWithoutInsurence-3000)*0.1);
            }
            else if (salaryWithoutInsurence > 12000 && salaryWithoutInsurence<=25000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + 1200*0.1 + (salaryWithoutInsurence-3000-12000)*0.2);
            }
            else if (salaryWithoutInsurence > 25000 && salaryWithoutInsurence<=35000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + 1200*0.1 + 25000*0.2 +  (salaryWithoutInsurence-3000-12000-25000)*0.25);
            }
            else if (salaryWithoutInsurence > 35000 && salaryWithoutInsurence<=55000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + 1200*0.1 + 25000*0.2 + 35000* 0.25 + (salaryWithoutInsurence-3000-12000-25000-35000)*0.3);
            }
            else if (salaryWithoutInsurence > 55000 && salaryWithoutInsurence<=80000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + 1200*0.1 + 25000*0.2 + 35000* 0.25 + 55000*0.3 + (salaryWithoutInsurence-3000-12000-25000-35000-55000)*0.35);
            }
            else if (salaryWithoutInsurence > 80000){
                salaryAfterTax = (salary-1800) - (3000*0.03 + 1200*0.1 + 25000*0.2 + 35000* 0.25 + 55000*0.3 + 80000*0.35 + (salaryWithoutInsurence-3000-12000-25000-35000-55000-80000)*0.45);
            }
        }
        return salaryAfterTax;
    }

}

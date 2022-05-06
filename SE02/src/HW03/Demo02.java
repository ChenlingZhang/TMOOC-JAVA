package HW03;

import java.util.HashMap;
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入需要检测的数字: ");
        String number = in.nextLine();
        char[] chars = number.toCharArray();
        for (char c: chars) {
            if (hashMap.containsKey(c)){
                int count = hashMap.get(c);
                hashMap.replace(c,count,count+1);
            }
            else{
                hashMap.put(c,1);
            }
        }
        String result = hashMap.toString();
        System.out.println(result);
    }
}

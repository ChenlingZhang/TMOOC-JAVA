package cn.tedu.OOPCase.Day04;

import java.util.Arrays;

/**
 * 数组拷贝方法
 * 1. Arrays.copyOf----基于源数组扩容的情况下使用的
 * 2. System.arraycopy -----存在两个数组，例如将A数组的内容拷贝到B数组中
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] array = {};
        System.out.println("扩容前的长度: " + array.length);
        array = Arrays.copyOf(array,array.length+1);
        System.out.println("扩容后的长度: "+array.length);
        // System.arraycopy
        // 1. 拷贝源数组
        // 2. 从开呗的原数组那个索引开始拷贝
        // 3. 要拷贝到的数组目标
        int[] arr1 = {50,80,60,70,80,90};
        int[] arr2 = {1,2,3,4,5,6};
        System.arraycopy(arr1,0,arr2,0,arr1.length);

    }

}

package com.lh.arithmetic;

import java.util.Arrays;

public class ArrayUtil {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(initArray(100)));
    }

    /**
     * 初始化一个大小为 count 的数组，元素为随机数
     *
     * @param count 数组大小
     * @return
     */
    public static int[] initArray(int count) {
        int[] arr = new int[count];
        for (int i = 0 ; i < count; i++) {
            int num = (int) (Math.random() * 100);
            arr[i] = num;
        }
        return arr;
    }
}

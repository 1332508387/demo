package com.lh.arithmetic;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 0, 5, 56, 89, 10, 4, 3, 32};
        quickSort(arr, 0, arr.length - 1);
        String string = Arrays.toString(arr);
        System.out.println(string);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (array[right] >= key && right > left) {
                right--;
            }
            array[left] = array[right];
            while (array[left] <= key && right > left) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = key;
        return right;
    }
}

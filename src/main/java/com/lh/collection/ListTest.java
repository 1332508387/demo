package com.lh.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * List 有序、可重复
 */
public class ListTest {
    public static void main(String[] args) {
//        System.out.println("123".hashCode());
        int h = "56489".hashCode();
        System.out.println(h % 8);
        System.out.println(h & 7);
    }

    /**
     * ArrayList 使用数据存储元素
     */
    @Test
    public void testArrayList() {
        ArrayList<Integer> nums = new ArrayList<>();
        // 调用 Arrays.copyOf() 方法进行扩容
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        // 调用 System.arraycopy 方法进行元素移动操作
        nums.remove(1);
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            iterator.remove();
            System.out.println(element);
        }
        System.out.println(nums);
        int i = 13;
        System.out.println(i >> 1);
    }

    @Test
    public void testArray() {
        String[] strs = {};
        String[] newStr = Arrays.copyOf(strs, 10);
        System.out.println(strs == newStr);

        String[] elementData = {"a", "b", "c", "d", "e"};
        System.out.println(elementData);
        this.printArray(elementData);
        System.arraycopy(elementData, 2, elementData, 1, 3);
        elementData[elementData.length -1] = null;
        System.out.println(elementData);
        this.printArray(elementData);
    }

    private void printArray(Object[] o) {
        int len = o.length;
        for (int i = 0; i < len; i++) {
            System.out.print(o[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(1);
        list.remove(1);

        /*for (Integer ele : list) {
            System.out.println(ele);
        }*/

        list.forEach(n -> System.out.println(n));
        list.forEach(System.out :: println);
    }
}

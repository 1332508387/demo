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
    /**
     * ArrayList
     */
    @Test
    public void testArrayList() {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
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
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("拉格朗日");
        list.add("拉普拉斯");
        list.add("瓦尔德内尔");

        for (String ele : list) {
            System.out.println(ele);
        }
    }
}

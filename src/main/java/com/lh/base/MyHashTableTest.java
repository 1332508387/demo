package com.lh.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MyHashTableTest {
    private static final int CAPACITY = 64;
    private Object[] data = new Object[CAPACITY];

    @Test
    public void test1() {
        String[] strs = {"aaa", "ertgdfg", "adftgwefgv", "adgdfgsd", "aergrthhfg"};
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int hash = strs[i].hashCode();
            int index = (CAPACITY - 1) & (hash ^ (hash >>> 16));
            if (data[index] != null) {
                data[index + 1] = strs[i];
                continue;
            }
            data[index] = strs[i];
        }

        String string = Arrays.toString(data);
        System.out.println(string);
    }
}

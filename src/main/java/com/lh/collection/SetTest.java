package com.lh.collection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Set 无序的，不可重复的，不支持索引访问
 */
public class SetTest {
    /**
     * HashSet 使用 HashMap 存放数据
     */
    @Test
    public void testHashSet() {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(3);

        set.remove(1);
        System.out.println(set);
    }

    /**
     * LinkedHashSet 使用 LinkedHashMap 存放数据
     */
    @Test
    public void testLinkefHashSet() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(2);
        set.add(1);

        set.remove(2);

        System.out.println(set);

    }

    /**
     * TreeSet 使用 TreeMap 存放元素
     */
    @Test
    public void testTreeSet() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(1);

        set.remove(3);

        System.out.println(set);
    }
}

package com.lh.collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    /**
     * HashMap key不能重复，当key一样时，第二个将会把第一个替换掉；key可以null，但只能有一个key为null
     */
    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "拉普拉斯");
        map.put(null, "拉格朗日");
        map.put(null, "拉格朗日2");
        map.put("age", "23");

        System.out.println(map);
    }

    @Test
    public void testLinkedHahsMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "拉普拉斯");
        map.put("name", "拉格朗日");
        map.put("age", "32");

        Set<String> strings = map.keySet();
        for (String key:strings) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }

    @Test
    public void testTreeMap() {

    }
}

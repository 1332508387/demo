package com.lh.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

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
        map.put("", "拉格朗日2");
        map.put("age", "23");

        map.get("name");
        map.remove("age");

        System.out.println(map);
    }

    /**
     * LinkedHashMap：继承 HashMap
     * Entry 维护顺序（双向链表）
     * static class Entry<K,V> extends HashMap.Node<K,V> {
         Entry<K,V> before, after;
         Entry(int hash, K key, V value, Node<K,V> next) {
         super(hash, key, value, next);
         }
     }
     */
    @Test
    public void testLinkedHahsMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "拉普拉斯");
        map.put("name", "拉格朗日");
        map.put("age", "32");
        map.get("name");

        Set<String> strings = map.keySet();
        for (String key:strings) {
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
    }

    /**
     * TreeMap key可以重复，但第二个将覆盖第一个的值；key不允许为null，会报错（NPE）
     */
    @Test
    public void testTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("name", "拉普拉斯");
//        treeMap.put(null, "拉格朗日");
        treeMap.put("age", "33");

        Set<Map.Entry<String, String>> entries = treeMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(
                    entry.getKey() + "=" + entry.getValue()
            );
        }

        class Person implements Comparable<Person> {
            public String name;
            public Integer age;

            public Person() {}

            public Person(String name, Integer age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(Person person) {
                return this.age - person.age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        Person person = new Person("拉格朗日" , 21);
        Person person1 = new Person("拉普拉斯" , 32);
        Person person2 = new Person("阿兹卡班" , 50);
        Person person3 = new Person("邓布利多" , 10);
        TreeMap<Person, Integer> personMap = new TreeMap<>();
        personMap.put(person, person.age);
        personMap.put(person1, person1.age);
        personMap.put(person2, person2.age);
        personMap.put(person3, person3.age);
        int size = personMap.size();
        System.out.println(personMap);

    }
}

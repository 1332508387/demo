package com.lh.base;

public class BaseTest {
//    @Test
    public void test() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);             // true
        System.out.println(e == f);             // false
        System.out.println(c == (a + b));       // true
        System.out.println(c.equals(a + b));    // true
        System.out.println(g == (a + b));       // true
        System.out.println(g.equals(a + b));    // false
        long l = 3L;
        int i = 3;
        System.out.println(l == i);             // true
    }

    public static enum E{
        Intance
    }
}

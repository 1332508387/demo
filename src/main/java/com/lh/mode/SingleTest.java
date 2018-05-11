package com.lh.mode;

import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTest {
    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Single3.SINGLE);
        System.out.println(Single3.SINGLE);
        Constructor<?>[] declaredConstructors = Single3.class.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            constructor.newInstance();
        }
        /*Constructor<Single3> construtor = Single3.class.getConstructor();
        construtor.setAccessible(true);
        Single3 single3 = construtor.newInstance();
        System.out.println(single3);*/
    }

    @Test
    public void test2() {
        System.out.println(Single2.getSingle());
        System.out.println(Single2.getSingle());
    }

    @Test
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Single1.getSingle());
        System.out.println(Single1.getSingle());

        Constructor<Single1> constructor = Single1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Single1 single1 = constructor.newInstance();
        System.out.println(single1);
    }
}

package com.lh.mode.single;

/**
 * 单例模式：懒加载
 */
public class Single2 {
    private static Single2 SINGLE;

    private Single2() {

    }

    public static synchronized Single2 getSingle() {
        if (SINGLE == null) {
            SINGLE = new Single2();
        }
        return SINGLE;
    }
}

package com.lh.mode.single;

/**
 * 单利模式：非懒加载
 */
public class Single1 {
    private static final Single1 SINGLE = new Single1();

    private Single1() {
        // 防反射
        if (SINGLE != null) {
            throw new RuntimeException("");
        }
    }

    public static Single1 getSingle() {
        return SINGLE;
    }
}

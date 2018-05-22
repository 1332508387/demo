package com.lh.mode.single;

/**
 * 单例模式：双重检查
 */
public class Single4 {
    public static Single4 SINGLE;

    public Single4() {
        if (SINGLE != null) {
            throw new RuntimeException();
        }
    }

    public static Single4 getSINGLE() {
        if (SINGLE == null) {
            synchronized (String.class) {
                if (SINGLE == null) {
                    SINGLE = new Single4();
                }
            }
        }
        return SINGLE;
    }
}

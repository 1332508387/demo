package com.lh.mode.single;

/**
 * 静态内部类实现单例
 */
public class Single5 {

    private Single5() {}

    private static class SingleInner {
        private static final Single5 SINGLE = new Single5();
    }

    public static Single5 getSingle() {
        return SingleInner.SINGLE;
    }
}

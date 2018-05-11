package com.lh.mode;

public class Single5 {
    private static Single5 SINGLE;

    private Single5() {
        if (SINGLE != null) {
            throw new RuntimeException();
        }
    }

    private static class SingleInner {
        private static final Single5 SINGLE = new Single5();
    }

    public static Single5 getSingle() {
        return SingleInner.SINGLE;
    }
}

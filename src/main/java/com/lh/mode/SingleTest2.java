package com.lh.mode;

public class SingleTest2 {
    static class Single {
        // 使用 volatile 防止指令重排序
        private volatile static Single single;

        private Single() {}

        public static Single getSingle() {
            Single s = single;
            if (s == null) {
                synchronized (String.class) {
                    s = single;
                    if (s == null) {
                        s = new Single();
                        single = s;
                        System.out.println("single 实例被创建了。。。");
                    }
                }
            }
            return s;
        }
    }


    private static final int THREAD_NUM = 10000;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(
                    () -> {
                        Single single = Single.getSingle();
                        System.out.println(single);
                    }
            );
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }




}

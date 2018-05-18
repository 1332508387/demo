package com.lh.mode;

public class SingleTest2 {
    static class Single {
        private static Single single;
        private static String[] names;

        static {
            names = new String[1000];
            for (int i = 0; i < 1000; i++) {
                names[i] = "12345";
            }
        }

        private Single() {}

        public static Single getSingle() {
            if (single == null) {
                synchronized (String.class) {
                    if (single == null) {
                        single = new Single();
                        System.out.println("single 实例被创建了。。。");
                    }
                }
            }
            return single;
        }
    }


    private static final int THREAD_NUM = 10000;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(
                    () -> {
                        Single single = Single.getSingle();
                        System.out.println(single.names);
                    }
            );
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }




}

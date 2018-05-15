package com.lh.thread;

import java.util.concurrent.TimeUnit;

public class ValatileTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Thread1()).start();
        }

        Thread.sleep(2000);
        System.out.println("change");
        Thread1.flag = true;

       /* while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println("exit");*/
    }

    static class Thread1 implements Runnable {
        public static volatile boolean flag = false;

        @Override
        public void run() {
            while (true) {
                if (flag) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getId() + "执行中。。。");

                        try {
                           Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

package com.lh.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    static class ThreadLocalObj implements Runnable {
        ThreadLocal<Integer> t = new ThreadLocal<>();
        ThreadLocal<String> t2 = new ThreadLocal<>();

        @Override
        public void run() {
            t.set((int) (Math.random() * 100));
            t2.set((int)(Math.random() * 100) + "");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.get());
            System.out.println(t2.get());
        }
    }

    static AtomicInteger a  = new AtomicInteger();

    public static void main(String[] args){
//        ThreadLocalObj threadLocalObj = new ThreadLocalObj();
//        new Thread(threadLocalObj).start();
//        new Thread(threadLocalObj).start();
        System.out.println(a.getAndAdd(0x61c88647) & 3);
        System.out.println(a.getAndAdd(0x61c88647) & 3);
        System.out.println(a.getAndAdd(0x61c88647) & 3);
//        System.out.println(a.getAndAdd(0x61c88647)& 3);
//        System.out.println(a.getAndAdd(0x61c88647)& 3);
//        System.out.println(a.getAndAdd(0x61c88647)& 3);
    }

}

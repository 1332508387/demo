package com.lh.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static final int COUNT = 5;
    public static CountDownLatch countDownLatch = new CountDownLatch(COUNT);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Num(countDownLatch)).start();
        }

        /*while (Thread.activeCount() > 1) {
            Thread.yield();
        }*/
        countDownLatch.await();
        System.out.println(Num.num);
    }

   static class Num implements Runnable {
        public CountDownLatch latch;
        public static int num = 0;
        public static Lock lock = new ReentrantLock();

        public Num(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
//        System.out.println(Thread.currentThread().getId());
            for (int i = 0; i < 1000; i++) {
                add();
            }
            latch.countDown();
        }

        public static void add() {
            lock.lock();
            num++;
            lock.unlock();
        }


    }

}


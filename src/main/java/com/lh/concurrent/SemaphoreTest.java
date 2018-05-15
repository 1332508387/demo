package com.lh.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static class SemaphoreRunnable implements Runnable {
        private Semaphore semaphore;

        public SemaphoreRunnable(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "进来了。。。");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.semaphore.release();
            }

        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 2; i++) {
            new Thread(new SemaphoreRunnable(semaphore)).start();
        }

        while (true);
    }
}

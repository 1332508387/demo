package com.lh.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static class CyclicBarrierRunnable implements Runnable {
        private CyclicBarrier barrier1;
        private CyclicBarrier barrier2;

        public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
            this.barrier1 = barrier1;
            this.barrier2 = barrier2;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "等待在在 barrier1。。。");
                barrier1.await();

                System.out.println(Thread.currentThread().getName() + "等待在 barrier2。。。");
                barrier2.await();

                System.out.println(Thread.currentThread().getName() + "执行完毕。。。");

                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier barrier1 = new CyclicBarrier(2, () -> System.out.println("barrier1 的 barrierAction 被执行，两个线程到达了 barrier1 处。。。"));
        CyclicBarrier barrier2 = new CyclicBarrier(2, () -> System.out.println("barrier2 的 barrierAction 被执行，两个线程到达了 barrier2 处。。。"));

        new Thread(new CyclicBarrierRunnable(barrier1, barrier2)).start();
        new Thread(new CyclicBarrierRunnable(barrier1, barrier2)).start();

        while (true);
    }
}

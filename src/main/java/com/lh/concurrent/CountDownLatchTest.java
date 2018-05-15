package com.lh.concurrent;

import sun.applet.Main;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static class Writer implements Runnable {
        private CountDownLatch countDownLatch;

        public Writer(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("aaa");
                // 计数 - 1
                this.countDownLatch.countDown();

                Thread.sleep(1000);
                System.out.println("bbb");
                this.countDownLatch.countDown();

                Thread.sleep(1000);
                System.out.println("ccc");
                this.countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Finish implements Runnable {
        private CountDownLatch countDownLatch;

        public Finish(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                // 计数不为 0，等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("写完成");
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Writer(countDownLatch)).start();
        new Thread(new Finish(countDownLatch)).start();
    }

}

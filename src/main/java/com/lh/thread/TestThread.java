package com.lh.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestThread {
    public static BlockingQueue<Integer> repository = new ArrayBlockingQueue<Integer>(10);

    static class Producer implements Runnable {
        Random random = new Random();
        @Override
        public void run() {
            while (true) {
                int num = random.nextInt();
                try {
                    repository.put(num);
                    System.out.println(Thread.currentThread().getId() + "生产了一个：" + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    Integer take = repository.take();
                    System.out.println("获取了：" + take);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread p = new Thread(new Producer());
        p.start();

        Thread c = new Thread(new Consumer());
        c.start();
    }
}

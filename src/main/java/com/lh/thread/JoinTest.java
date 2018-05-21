package com.lh.thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
           while (true) {
               System.out.println(Thread.currentThread().getId() + "我每隔一秒输出一次。。。");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getId() + "我先睡5秒。。。");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread2.join();
        System.out.println("exit...");

    }
}

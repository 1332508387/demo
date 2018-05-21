package com.lh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WatiTest {
    static class Wait implements Runnable {
        private Object object;

        public Wait(Object object) {
            this.object = object;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getId() + "等待者等待被唤醒。。。");
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println(Thread.currentThread().getId() + "被唤醒了。。。");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }

    static class Notify implements Runnable {
        private Object object;

        public Notify(Object object) {
            this.object = object;
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
//                object.notify();
                object.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(new Wait(o)).start();
        new Thread(new Wait(o)).start();

        new Thread(new Notify(o)).start();

        while (true) ;
    }

}

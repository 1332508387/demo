package com.lh.thread;

public class VolatileTest {
    private static final int THREAD_NUM = 5;

    public static void main(String[] args) throws InterruptedException {
        Work w = new Work();
        new Thread(new Thread2(w)).start();
        new Thread(new Thread2(w)).start();
        new Thread(new Thread2(w)).start();

        Thread.sleep(2000);

        new Thread(new Thread1(w)).start();

        Thread.sleep(5000);
    }

    static class Thread1 implements Runnable {
        private Work work;

        public Thread1(Work work) {
            this.work = work;
        }

        @Override
        public void run() {
            work.shutdown();
        }
    }

    static class Thread2 implements Runnable {
        private Work work;

        public Thread2(Work work) {
            this.work = work;
        }

        @Override
        public void run() {
            try {
                work.doWork();
                System.out.println(Thread.currentThread().getId() + "stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

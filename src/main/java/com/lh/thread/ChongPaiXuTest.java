package com.lh.thread;

public class ChongPaiXuTest {
    static class Change {
        int a = 0;
        volatile boolean flag = false;

        public void write() {
            a = 1;
            flag = true;
        }

        public void read() {
            if (flag) {
                int b = a * a;
                System.out.println(b);
            }
        }
    }

    static class Thread1 implements Runnable {
        private Change change;

        public Thread1(Change change) {
            this.change = change;
        }

        @Override
        public void run() {
            change.write();
        }
    }

    static class Thread2 implements Runnable {
        private Change change;

        public Thread2(Change change) {
            this.change = change;
        }

        @Override
        public void run() {
            change.read();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Change change = new Change();
        new Thread(new Thread1(change)).start();
        new Thread(new Thread2(change)).start();

        Thread.sleep(5000);
    }
}

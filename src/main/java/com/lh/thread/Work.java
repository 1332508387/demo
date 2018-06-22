package com.lh.thread;

public class Work {
    private volatile boolean flag = false;

    public void shutdown() {
        this.flag = true;
    }

    public void doWork() throws InterruptedException {
        int count = 0;
        while (!flag) {
            System.out.println(Thread.currentThread().getId() + "->" + count++);
        }
    }
}

package com.lh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        service.execute(() -> System.out.println(Thread.currentThread().getId() + "执行了。。。"));

        service.shutdown();
    }
}

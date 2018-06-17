package com.lh.distributed.token_bucket;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ItemController {
    private static final double TOKEN_NUM = 2.0;
    private static RateLimiter rateLimiter = RateLimiter.create(TOKEN_NUM);

    public void getItemById(Long iid) {
        if (!rateLimiter.tryAcquire()) {
            System.out.println("limit");
        }
        System.out.println("获取了Item" + iid);
    }

    private static final int THREAD_NUM = 10;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < THREAD_NUM; i++) {
            service.submit(() -> {
                ItemController itemController = new ItemController();
                itemController.getItemById(1L);
            });
            Thread.sleep(100);
        }
        service.shutdown();
    }
}

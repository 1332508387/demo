package com.lh.distributed;

import com.google.common.util.concurrent.RateLimiter;
import jdk.nashorn.internal.parser.Token;
import org.apache.tools.ant.taskdefs.Execute;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 令牌桶限流
 */
public class TokenBucketTest {
    static class Service implements Runnable {
        private RateLimiter limiter;

        public Service(RateLimiter limiter) {
            this.limiter = limiter;
        }

        @Override
        public void run() {
            while (true) {
                limiter.acquire();
                getData();
            }
        }

        public void getData() {
            System.out.println(Thread.currentThread().getId() + "访问服务。。。");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static final int THREAD_NUM = 3;
    private static final int TOKEN_NUM = 1;

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(TOKEN_NUM);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            executorService.execute(new Service(limiter));
        }
        executorService.shutdown();
    }
}

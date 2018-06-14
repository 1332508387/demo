package com.lh.thread.executor;

import org.junit.jupiter.api.Test;
import org.springframework.util.PropertyPlaceholderHelper;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i <5; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getId() + "执行了"));
        }
        service.shutdown();
    }

    /**
     * ThreadPoolExecutor(int corePoolSize,     // 在池中保存的线程数量，即使它们是空闲的
                         int maximumPoolSize,   // 在池中允许的线程的最大数量
                         long keepAliveTime,    // 当线程的数量大于核心时，这是多余的空闲线程在终止之前等待新任务的最大时间
                         TimeUnit unit,         // 时间单位
                         BlockingQueue<Runnable> workQueue) // 用于在执行任务之前执行任务的队列
     */
    static int count = 0 ;
    @Test
    public void testThreadPoolExecutor() throws InterruptedException {
        final int threadNum = 100;
        final int corePoolSize = 5;
        final int maxPoolSize = 6;
        final long keepAliveTime = 5L;
        CountDownLatch latch = new CountDownLatch(threadNum);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
                SECONDS, new LinkedBlockingQueue<Runnable>(5));

        for (int i = 0; i < threadNum; i++) {
            executor.submit(() -> {
                count++;
                System.out.println(Thread.currentThread().getId());
                latch.countDown();
            });
        }
        executor.shutdown();

        latch.await();
    }
}

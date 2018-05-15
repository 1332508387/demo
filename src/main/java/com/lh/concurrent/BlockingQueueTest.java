package com.lh.concurrent;

import org.junit.jupiter.api.Test;
import sun.awt.SunHints;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue 接口表示一个线程安全放入和提取实例的队列
 * 通常用于一个线程生产对象，而另外消费这些的场景。
 */
public class BlockingQueueTest {
    @Test
    public void test() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue(10);
        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.remove("2");
        for (String string : queue) {
            System.out.println(string);
        }
    }

    @Test
    public void ArrayBlockingQueue() {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);

        class Productor implements Runnable {
            private BlockingQueue<String> queue;


            public Productor(BlockingQueue<String> queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                try {
                    queue.put("拉格朗如");
                    Thread.sleep(2000);
                    queue.put("拉普拉斯");
                    Thread.sleep(2000);
                    queue.put("高斯");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        class Consumer implements Runnable {
            private BlockingQueue<String> queue;

            public Consumer(BlockingQueue queue) {
                this.queue = queue;
            }

            @Override
            public void run() {
                try {
                    while (true) {
                        String value = queue.take();
                        System.out.println("娶到了一个元素：" + value);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        new Thread(new Productor(queue)).start();
        new Thread(new Consumer(queue)).start();

        while (true);

    }
}

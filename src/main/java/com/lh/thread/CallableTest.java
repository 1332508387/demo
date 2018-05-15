package com.lh.thread;

import java.util.concurrent.*;

public class CallableTest {
    static class CallableImpl implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("我是一个 Callable。。。");
            return "success";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> submit = service.submit(new CallableImpl());
        String s = submit.get();
        System.out.println(s);
    }

}

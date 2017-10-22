package com.rockydang.service.springdemo.common.jdk8.completablefuture;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanxiao on 2017/7/13.
 */
public class TestCompletableFuture {
    private static ThreadPoolExecutor publishExecutor = new ThreadPoolExecutor(32, 32, 1000,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue(500), new ThreadPoolExecutor.CallerRunsPolicy());
    public String asncSend() {
        publishExecutor.execute(() -> {
            try {
                Thread.sleep(1000 * 10);
                System.out.println("11121212");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return "aaa";
    }

    public static void main(String[] args) {
        TestCompletableFuture testCompletableFuture = new TestCompletableFuture();
        String a = testCompletableFuture.asncSend();
        System.out.println(a);
    }

}

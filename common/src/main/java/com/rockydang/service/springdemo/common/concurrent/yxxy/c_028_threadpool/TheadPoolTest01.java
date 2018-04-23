package com.rockydang.service.springdemo.common.concurrent.yxxy.c_028_threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanxiao on 2018/3/10.
 */
public class TheadPoolTest01 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(3), r -> {
            Thread t = new Thread(r);
            System.out.println("生成线程" + t);
            return t;
        }, new ThreadPoolExecutor.CallerRunsPolicy());

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "在忙...");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            executor.execute(r);
        }

        System.out.println(executor);
        executor.shutdown();
    }
}

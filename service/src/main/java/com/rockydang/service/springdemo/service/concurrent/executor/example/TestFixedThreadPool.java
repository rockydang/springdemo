package com.rockydang.service.springdemo.service.concurrent.executor.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定长度的线程池
 * 1.将请求处理[任务提交]与[任务的实际执行]解耦开来
 */
public class TestFixedThreadPool {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //任务提交
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "线程被调用了。");
                }
            };
            //任务执行
            executorService.execute(task);
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }
}



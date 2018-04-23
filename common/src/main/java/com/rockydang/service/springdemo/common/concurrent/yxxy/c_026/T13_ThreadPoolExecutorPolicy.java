/**
 * 自定义线程池
 */
package com.rockydang.service.springdemo.common.concurrent.yxxy.c_026;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class T13_ThreadPoolExecutorPolicy {
    public static void main(String[] args) throws InterruptedException {

        //1.线程池执行类,3个核心线程、5个最大线程,有界阻塞线程池3,策略为阻塞处理;
        //用于被拒绝任务的处理程序，它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
        /* ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 20L, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.CallerRunsPolicy());
        */

       /*  // 抛出异常的方式（AbortPolicy）
       ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.AbortPolicy());*/

        //丢弃当前将要加入队列的任务本身（DiscardPolicy）
       /* ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.DiscardPolicy());*/

        //丢弃任务队列中最旧任务（DiscardOldestPolicy）
        ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.DiscardOldestPolicy());

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 12; i++) {
            service.execute(() -> {
                atomicInteger.incrementAndGet();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().setName("i=" + atomicInteger.get());
                System.out.println(Thread.currentThread().getName());
            });
        }
        TimeUnit.SECONDS.sleep(15);

        System.out.println("service1111=" + service);
        service.shutdown();
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println("service2=" + service);

        TimeUnit.SECONDS.sleep(5);
        System.out.println(service.isTerminated());
        System.out.println(service.isShutdown());
        System.out.println("service3=" + service);

    }
}

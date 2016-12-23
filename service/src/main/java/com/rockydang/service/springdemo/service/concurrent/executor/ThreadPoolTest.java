package com.rockydang.service.springdemo.service.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);

        //corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
        //maximumPoolSize：池中允许的最大线程数
        //keepAliveTime：线程池中的空闲线程所能持续的最长时间
        //unit：持续时间的单位。
        //workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。

        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, bqueue);

        //创建七个任务
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();
//        Runnable t8 = new MyThread();

        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
//        pool.execute(t8);

        //关闭线程池
        pool.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
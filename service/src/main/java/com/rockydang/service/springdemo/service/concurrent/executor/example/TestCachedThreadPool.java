package com.rockydang.service.springdemo.service.concurrent.executor.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cacheThreadPool
 * <p>
 * 1.newCachedThreadPool工厂方法将线程池最大大小设置成Integr.MAX_VALUE,而将基本大小设置成0
 * 并将超时设置成1分钟;
 * 2.这种方法创建出来的线程池可以被无限扩展,并且当需求降低时会自动收缩;
 * <p>
 * 3.关于SynchronousQueue
 * 3.1 对于非常大或者无界的线程池,可以通过使用SynchronousQueue来避免任务排队,
 * 以及直接将任务从生产者移交给工作者线程;
 * 3.2 SynchronousQueue并不是一个真正的队列,而是一个线程间进行交换的机制;
 * 3.3 要想将一个元素放入到SynchronousQueue中,必须有另外的一个线程正在等待接受这个元素;
 */
public class TestCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }

        executorService.shutdown();
    }
}

class TestRunnable implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}

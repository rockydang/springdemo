package com.rockydang.service.springdemo.service.concurrent.executor.example;

import java.util.concurrent.Executor;

/**
 * 并发不好的例子
 * 1.虽然对于单线程设计来看,执行效率上有了大幅度的提升;
 * 2.但是由于每次都要产生一个新的线程,会出现负载的情况;
 * 3.不足:
 * a.生命周期的开销非常高;
 * b.资源消耗
 * c.稳定性
 */
public class ConcurrentBadExample {

    public void testSerial() {
        //创建10个任务并执行
        for (int i = 0; i < 10; i++) {
            final int a = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    print(String.valueOf(a));
                }
            };
            new Thread(task).start();
        }
    }
    public static void print(String str) {
        System.out.println("str=" + str + "&threadName=" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ConcurrentBadExample concurrentBadExample = new ConcurrentBadExample();
        concurrentBadExample.testSerial();
    }
}


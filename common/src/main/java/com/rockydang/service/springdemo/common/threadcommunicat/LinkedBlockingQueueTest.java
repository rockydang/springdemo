package com.rockydang.service.springdemo.common.threadcommunicat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 通过linkedblockingQueue 构建线程间通信
 * @author leo-zeng
 *
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        threadPool.execute(new Producer(queue));
        threadPool.execute(new Consumer(queue));

        if(!threadPool.isShutdown()){
            threadPool.shutdown();
            try {
                threadPool.awaitTermination(300, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

class Producer extends Thread{
    private LinkedBlockingQueue<String> queue;

    public Producer(LinkedBlockingQueue<String> queue) {
        this.queue =queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("生产出:"+i);
            try {
                Thread.sleep(100);
                queue.put(new String("producer:"+i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer extends Thread{
    private LinkedBlockingQueue<?> queue;

    public Consumer(LinkedBlockingQueue<String> q) {
        this.queue =q;
    }
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("consumer 消费了:"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
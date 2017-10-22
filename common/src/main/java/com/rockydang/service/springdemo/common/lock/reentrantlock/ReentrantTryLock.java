package com.rockydang.service.springdemo.common.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock来保护对象状态
 * <p>
 * Created by yanxiao on 2017/3/4.
 */
public class ReentrantTryLock extends Thread {

    ReentrantLock lock = new ReentrantLock();

    public void testLock() throws InterruptedException {
        //过已经被lock,则返回false
        if (lock.tryLock()) {
            try {
                System.out.println("得到锁操作... 休眠1s.");
                Thread.sleep(1000);
                System.out.println("休眠结束...");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("得不到锁...");
        }
    }

    public void run() {
        try {
            testLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantTryLock reentrantTryLock = new ReentrantTryLock();

        Thread t1 = new Thread(reentrantTryLock);
        Thread t2 = new Thread(reentrantTryLock);
        t1.start();
        t2.start();
    }

}

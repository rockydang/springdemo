package com.rockydang.service.springdemo.common.lock.reentrantlock;

import lombok.experimental.Accessors;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 带有时间限制的加锁
 * <p>
 * 使用tryLock(long timeout, TimeUnit unit)获取锁，此时有点像lock()和lockInterruptibly()的混合体，
 * 若获锁取成功，直接返回true；若获取失败跑一个for循环，
 * 则用 LockSupport.parkNanos(this, nanosTimeout)
 * 阻塞进程并放入等待队列，等待唤醒，同时timeout扣减每次循环消耗的时间，
 * 当timeout用尽时如果依然没有获取到锁，那么就返回false。
 * <p>
 * Created by yanxiao on 2017/3/4.
 */
@Accessors(chain = true)
public class ReentranTryLockTimeout extends Thread {

    ReentrantLock lock = new ReentrantLock();

    public boolean trySendOnSharedLine() throws InterruptedException {

        //如果已经被lock，尝试等待4s，看是否可以获得锁，如果4s后仍然无法获得锁则返回false继续执行
        long second = 4;
        if (!lock.tryLock(second, TimeUnit.SECONDS)) {
            System.out.println("得不到锁");
            return false;
        }

        try {
            System.out.println("得到锁。。。");
            return sendOnSharedLine();
        } finally {
            lock.unlock();
        }
    }

    public void run() {
        try {
            trySendOnSharedLine();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean sendOnSharedLine() {
        System.out.println("。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        ReentranTryLockTimeout reentrantLockTest = new ReentranTryLockTimeout();

        Thread t1 = new Thread(reentrantLockTest);
        t1.start();

        Thread t2 = new Thread(reentrantLockTest);
        t2.start();

//        System.out.println("costTime::" + (System.currentTimeMillis() - startTime));
    }

}

package com.rockydang.service.springdemo.common.lock.reentrantlock;

import lombok.experimental.Accessors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 带有时间限制的加锁
 * Created by yanxiao on 2017/3/4.
 */
@Accessors(chain = true)
public class ReentrantLockInterrupt {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockInterrupt reentrantLockInterrupt = new ReentrantLockInterrupt();
//        reentrantLockInterrupt.lock();
//        reentrantLockInterrupt.lockInterrupt();
//        reentrantLockInterrupt.lockInterrupt2();
        reentrantLockInterrupt.lockInterruptUnLock();
    }

    //1

    /**
     * 主线程拿到锁之后不释放 ,则子线程会一直等待;
     *
     * @throws InterruptedException
     */
    public void lock() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread thread = new Thread(new Runnable() {
            //
            @Override
            public void run() {
                System.out.println("Thread name " + Thread.currentThread().getName() + " get lock!");
                lock.lock();
                System.out.println("拿到锁..");
                System.out.println("costTime ::" + (System.currentTimeMillis() - startTime));
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        lock.unlock();
    }

    //2
//    @Test

    /**
     * 1.线程中拿到中断信号:thread.interrupt()
     * 2.lockInterruptibly会先判断线程是否中断，如果中断直接throw InterruptedException
     *
     * @throws InterruptedException
     */
    public void lockInterrupt() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("Thread name " + Thread.currentThread().getName() + " is interrupted!");
                }
                System.out.println("costTime ::" + (System.currentTimeMillis() - startTime));
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    //3
//    @Test
    public void lockInterrupt2() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("Thread name " + Thread.currentThread().getName() + " is interrupted!");
                }
                System.out.println("costTime ::" + (System.currentTimeMillis() - startTime));
            }
        });
        thread.start();
        thread.interrupt();
    }

    //4
//    @Test
    public void lockInterruptUnLock() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        final Lock lock = new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread thread = new Thread(new Runnable() {
            //
            @Override
            public void run() {
                try {
                    System.out.println("lockInterruptUnLock...");
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println("Thread name " + Thread.currentThread().getName() + " is interrupted!");
                } finally {
                    lock.unlock();
                }
                System.out.println("costTime ::" + (System.currentTimeMillis() - startTime));
            }
        });
        thread.start();
        Thread.sleep(2000);
        lock.unlock();
    }
}

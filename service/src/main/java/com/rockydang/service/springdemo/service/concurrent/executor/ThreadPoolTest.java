package com.rockydang.service.springdemo.service.concurrent.executor;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        //创建等待队列
//        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<>(1);
        BlockingQueue<Runnable> bqueue = new LinkedBlockingDeque<>(1);

        //corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
        //maximumPoolSize：池中允许的最大线程数
        //keepAliveTime：线程池中的空闲线程所能持续的最长时间
        //unit：持续时间的单位。
        //workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务。

        //创建线程池，池中保存的线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 2, 50, TimeUnit.MILLISECONDS, bqueue,
                new ThreadPoolExecutor.DiscardPolicy());

        //1.优先使用corePoolSize创建队列;
        //2.如果corePoolSize满了之后,则将进程塞到队列中[ArrayBlockingQueue];
        //3.如果队列队列已经用满;判断如果线程数<maximumPoolSize,则新过来的请求会创建线程进行处理;
        //4.待线程池处理完成后,会继续消费存在队列中的请求;

        //待遗留的问题:
        //如果当执行线程完了之后,这时候又进来线程,是先执行新线程还是会将新线程放入到队列中?


        //创建七个任务
        Runnable t1 = new MyThread().setName("t1");
        Runnable t2 = new MyThread().setName("t2");
        Runnable t3 = new MyThread().setName("t3");
        Runnable t4 = new MyThread().setName("t4");
        Runnable t5 = new MyThread().setName("t5");
//        Runnable t6 = new MyThread().setName("t6");
//        Runnable t7 = new MyThread().setName("t7");
//        Runnable t8 = new MyThread().setName("t8");

        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        Thread.sleep(2000);
        pool.execute(t4);
        pool.execute(t5);
//        pool.execute(t6);
//        pool.execute(t7);
//        pool.execute(t8);

        //关闭线程池
        pool.shutdown();
    }
}

class MyThread implements Runnable {

    @Setter
    @Getter
    @Accessors(chain = true)
    String name;

    @Override
    public void run() {
        System.out.println(getName() + "---" + Thread.currentThread().getName() + "--run。。。。。");
        try {
            if (getName().equals("t1")) {
                Thread.sleep(4000);
            } else {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
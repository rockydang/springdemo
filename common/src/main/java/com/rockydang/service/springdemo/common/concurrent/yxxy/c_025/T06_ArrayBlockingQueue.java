package com.rockydang.service.springdemo.common.concurrent.yxxy.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        ////////  put数据    ////////
//		strs.put("aaa"); //满了就会等待，程序阻塞
//            strs.add("aaa");//满了就会抛出异常
//        strs.offer("aaa");//添加成功则返回true,否则false
      /*  strs.offer("aaa", 1, TimeUnit.SECONDS);
        System.out.println(strs);*/

        ////  take 数据 ////
        strs.clear();
//        System.out.println(strs.take()); //若为空,阻断进入等待状态直到BlockingQueue有新的对象被加入为止
//        System.out.println(strs.peek());//方法直接取出队头的元素，并不删除
//        System.out.println(strs.remove());//方法直接删除队头的元素
//        System.out.println(strs.poll());//获取并移除此队列的头，若不能立即取出，则可以等time参数规定的时间，取不到时返回null。
        System.out.println(strs.poll(1, TimeUnit.SECONDS));//获取并移除此队列的头，若不能立即取出，则可以等time参数规定的时间，取不到时返回null。
        System.out.println(strs);
    }
}

package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 并发流&串行流
 * Created by yanxiao on 2017/8/1.
 */
public class StreamTest6 {
    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        List<String> uuidList = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            uuidList.add(UUID.randomUUID().toString());
        }
        long endTime1 = System.nanoTime();
        System.out.println("生成uuid耗时:" + TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1));

        System.out.println("开始串行排序...");
        long startTime2 = System.nanoTime();
        uuidList.stream().sorted().count();
        long endTime2 = System.nanoTime();
        System.out.println("串行排序耗时:" + TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2));

        System.out.println("开始并行排序...");
        long startTime3 = System.nanoTime();
        uuidList.parallelStream().sorted().count();
        long endTime3 = System.nanoTime();
        System.out.println("并行排序耗时:" + TimeUnit.NANOSECONDS.toMillis(endTime3 - startTime3));
    }
}

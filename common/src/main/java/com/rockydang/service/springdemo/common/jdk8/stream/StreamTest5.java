package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.stream.IntStream;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest5 {
    public static void main(String[] args) {
        //distinct位置,导致程序一直执行
        //IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
        IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}

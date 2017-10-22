package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.stream.IntStream;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest1 {
    public static void main(String[] args) {
        IntStream.of(new int[]{1,2,3}).forEach(System.out::print);
        System.out.println("-----------------------------------");
        IntStream.range(2,5).forEach(System.out::print);
        System.out.println("-----------------------------------");
        IntStream.rangeClosed(2,5).forEach(System.out::print);
    }
}

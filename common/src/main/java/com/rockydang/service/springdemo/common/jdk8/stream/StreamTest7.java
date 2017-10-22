package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流的短路运算
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello1", "world", "aaa");
/*
        list.stream().mapToInt(item -> item.length()).filter(lenght -> lenght == 5)
                .findFirst().ifPresent(System.out::print);*/
        list.stream().mapToInt(item -> {
                    int length = item.length();
                    System.out.println(item);
                    return length;
                }
        ).filter(lenght -> lenght == 5)
                .findFirst().ifPresent(System.out::print);
    }
}

package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by yanxiao on 2017/8/29.
 */
public class StreamTest9 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");

        List<String> result = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + ":" + item2))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
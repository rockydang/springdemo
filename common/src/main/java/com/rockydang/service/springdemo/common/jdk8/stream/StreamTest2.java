package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);

        Integer a;
        a = integerList.stream().map(item -> item * 2).reduce(0, (item1, item2) -> Integer.sum(item1, item2));
        System.out.println("a=" + a);


        Integer b;
        b = integerList.stream().map(item -> item * 2).reduce(0, Integer::sum);
        System.out.println("b=" + b);
    }
}

package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest {
    public static void main(String[] args) {
        //流的创建方式
        //1.
        Stream s1 = Stream.of("a", "b", "c");

        //2.
        String[] array1= new String[]{"a","c"};
        Stream s2 = Stream.of(array1);

        //3.
        Stream s3 = Arrays.stream(array1);

        //4.
        List<String> list =Arrays.asList(array1);
        Stream s4 = list.stream();
    }
}

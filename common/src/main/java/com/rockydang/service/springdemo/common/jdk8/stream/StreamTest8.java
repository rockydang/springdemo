package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * flatMap
 */
public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "world welcome", "welcome welcome");

     /*   list.stream().map(item -> Arrays.asList(item.split(" ")))
                .distinct().collect(Collectors.toList()).forEach(System.out::println);*/


        list.stream().map(item -> item.split(" "))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);


    }
}

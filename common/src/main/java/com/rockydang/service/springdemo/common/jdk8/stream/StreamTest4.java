package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.stream.Stream;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest4 {
    public static void main(String[] args) {
       /* List<String> list = Lists.newArrayList("hello", "world", "hello world", "hello");
        //list.stream().forEach(String::toUpperCase);
        list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new)).forEach(System.out::print);
        System.out.println("--------------------------------------------");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        integerList.stream().map(item -> item * item).forEach(System.out::print);*/

      /*  Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3), Arrays.asList(4, 5));
        listStream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);*/

/*
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        stream.findFirst().ifPresent(System.out::print);
*/
//        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);


        //找出流中大于2的元素,然后将每个元素乘以2,然后忽略掉流中前两个元素,然后取出前两个元素,
        Stream<Integer> stream = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream.filter(item -> item > 2)
                .mapToInt(item -> item * 2)
                .skip(2)
                .limit(2)
                .sum());

    }
}

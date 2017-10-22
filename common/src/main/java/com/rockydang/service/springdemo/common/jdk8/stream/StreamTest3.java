package com.rockydang.service.springdemo.common.jdk8.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by yanxiao on 2017/7/16.
 */
public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world","hello");

        //1. lambda
        //String[] streamArray = stream.toArray(lenght -> new String[lenght]);
        //Arrays.asList(streamArray).forEach(System.out::println);

        //2. 方法引用
        //String[] streamArray1 = stream.toArray(String[]::new);
        //Arrays.asList(streamArray1).forEach(System.out::println);

        //3.stream to list
        /*List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);

        List<String> list1 = stream.collect(() -> new ArrayList<>()
                , (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));
        list1.forEach(System.out::println);

        List<String> list2 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list2.forEach(System.out::println);

        List<String> list3 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        list3.forEach(System.out::println);

        String contact = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        System.out.println(contact);*/

        //4.Collections
       /* List<String> list4 = stream.collect(Collectors.toCollection(ArrayList::new));
        list4.forEach(System.out::println);
        System.out.println("--------------------------");*/

        //5.转传成set
        /*Set<String> set1 = stream.collect(Collectors.toCollection(TreeSet<String>::new));
        set1.forEach(System.out::println);*/

        String joinStr = stream.collect(Collectors.joining()).toString();
        System.out.println(joinStr);
    }
}

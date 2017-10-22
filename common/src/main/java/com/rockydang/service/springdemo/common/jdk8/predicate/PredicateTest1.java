package com.rockydang.service.springdemo.common.jdk8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yanxiao on 2017/6/11.
 */
public class PredicateTest1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        PredicateTest1 predicateTest1 = new PredicateTest1();
       /* predicateTest1.test(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });*/
        predicateTest1.conditionFilter(list, item -> item % 2 == 0);
        System.out.println("-----");
        predicateTest1.conditionFilter(list, item -> true);

        System.out.println("----------");
        list.stream().forEach(item -> {
            if (item % 2 == 0) System.out.println(item);
        });
    }

    public void conditionFilter(List<Integer> lists, Predicate<Integer> predicate) {
        lists.stream().forEach(item -> {
            boolean flag = predicate.test(item);
            if (flag) {
                System.out.println(item);
            }
        });
    }
}

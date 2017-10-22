package com.rockydang.service.springdemo.common.jdk8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yanxiao on 2017/6/11.
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        predicateTest2.conditionAndFilter(list, item -> item % 2 == 0, item -> item > 3);
        System.out.println("-------");
        predicateTest2.conditionOrFilter(list, item -> item % 2 == 0, item -> item > 3);
        System.out.println("-------");
        predicateTest2.conditionNegateFilter(list, item -> item % 2 == 0, item -> item > 3);
        System.out.println("-----");

        System.out.println(predicateTest2.isEquals("test").test("test1"));

    }


    public void conditionAndFilter(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate1) {
        list.forEach(
                item -> {
                    if (predicate.and(predicate1).test(item)) {
                        System.out.println(item);
                    }
                }
        );

    }

    public void conditionOrFilter(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate1) {
        list.forEach(
                item -> {
                    if (predicate.or(predicate1).test(item)) {
                        System.out.println(item);
                    }
                }
        );

    }

    public void conditionNegateFilter(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate1) {
        list.forEach(
                item -> {
                    if (predicate.and(predicate1).negate().test(item)) {
                        System.out.println(item);
                    }
                }
        );
    }

    Predicate<String> isEquals(Object obj) {
        return Predicate.isEqual(obj);
    }


}

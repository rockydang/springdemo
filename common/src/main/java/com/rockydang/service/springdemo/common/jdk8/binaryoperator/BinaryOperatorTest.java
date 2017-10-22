package com.rockydang.service.springdemo.common.jdk8.binaryoperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 * Created by yanxiao on 2017/6/11.
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        Supplier<BinaryOperatorTest> binaryOperatorTestSupplier = BinaryOperatorTest::new;
        System.out.println(binaryOperatorTestSupplier.get().coupute(1, 2, (a, b) -> a + b));


        System.out.println("------");

        System.out.println(binaryOperatorTestSupplier.get().compareMinBy("a", "baa", (a, b) -> a.length() - b.length()));
        System.out.println("------");
        System.out.println(binaryOperatorTestSupplier.get().compareMaxBy("a", "baa", (a, b) -> a.length() - b.length()));


    }

    public int coupute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    public String compareMinBy(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }

    public String compareMaxBy(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.maxBy(comparator).apply(a, b);
    }
}

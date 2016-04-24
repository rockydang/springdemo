package com.rockydang.service.springdemo.common.annotation.example2;

/**
 * Created by yanxiao on 16/4/24.
 */
public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {

    }
}

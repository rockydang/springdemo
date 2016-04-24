package com.rockydang.service.springdemo.common.annotation.example3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxiao on 16/4/24.
 */
public class Sample3 {
    @ExceptionTest3(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest3(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest3(ArithmeticException.class)
    public static void m3() {

    }

    public static void doublyBad() {
        List<String> list = new ArrayList<String>();

        //the spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.add(5, null);
    }
}

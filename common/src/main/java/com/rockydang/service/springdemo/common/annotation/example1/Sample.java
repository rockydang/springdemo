package com.rockydang.service.springdemo.common.annotation.example1;

/**
 * Created by yanxiao on 16/4/24.
 */
public class Sample {
    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("");
    }

    public static void m4() {
    }

    @Test
    public  void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }

}

package com.rockydang.service.springdemo.common.jdk8.defaultmethod;

/**
 * Created by yanxiao on 2017/6/22.
 */
public interface MyInterface2 {

    default void myMethod1() {
        System.out.println("MyInterface2");
    }
}

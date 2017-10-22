package com.rockydang.service.springdemo.common.jdk8.defaultmethod;

/**
 * Created by yanxiao on 2017/6/22.
 */
public class MyClassTest implements MyInterface1, MyInterface2 {

    public static void main(String[] args) {
        MyClassTest myClassTest = new MyClassTest();
        myClassTest.myMethod1();
    }

    @Override
    public void myMethod1() {
        MyInterface2.super.myMethod1();
    }
}

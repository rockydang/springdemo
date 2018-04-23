package com.rockydang.service.springdemo.common.jvm.classloader;

import java.util.UUID;

/**
 * 当一个常量的值编译期间可以确定的,那么值在编译期间就不会被放到调用类的常量池中;
 * 这时在程序运行时,会导致主动使用这个常量所在的类,显然会导致这个类的初始化;
 *
 * @author by yanxiao on 2018/2/16.
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code.");
    }
}

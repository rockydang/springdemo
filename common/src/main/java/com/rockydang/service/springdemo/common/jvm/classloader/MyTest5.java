package com.rockydang.service.springdemo.common.jvm.classloader;

import java.util.Random;

/**
 * 当一个接口在初始化时,并不要求父接口都完成了初始化
 *
 * 只有在真正使用到父接口时(引用到了接口中定义的常量时),才会初始化
 * Created by yanxiao on 2018/2/16.
 */
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    public  static final int a = 5;
}

interface MyChild5 extends MyParent5 {
    public  static final int b = new Random().nextInt(3);
}
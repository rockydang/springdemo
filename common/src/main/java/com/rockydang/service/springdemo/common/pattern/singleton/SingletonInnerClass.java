package com.rockydang.service.springdemo.common.pattern.singleton;

import java.util.Arrays;

/**
 * 通过内部类方式,只初始化一次
 * 线程安全
 * <p>
 * Created by yanxiao on 2018/4/24.
 */
public class SingletonInnerClass {
    private SingletonInnerClass() {
        System.out.println("Singleton1");
    }

    private static class Inner {
        private static SingletonInnerClass s = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths = new Thread[200];

        for (int i = 0; i < ths.length; i++) {
            ths[i] = new Thread(() -> {
                SingletonInnerClass.getInstance();
            });
        }
        Arrays.asList(ths).forEach(o -> o.start());
    }
}

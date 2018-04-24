package com.rockydang.service.springdemo.common.pattern.singleton;

/**
 * 懒汉式,线程安全
 * 通过对象加锁的方式实现,性能较低
 * Created by yanxiao on 2018/4/24.
 */
public class SingletonSafe {

    private static SingletonSafe instance;

    private SingletonSafe() {

    }
    private static synchronized SingletonSafe getInstance() {
        if (instance == null) {
            instance = new SingletonSafe();
        }
        return instance;
    }
}

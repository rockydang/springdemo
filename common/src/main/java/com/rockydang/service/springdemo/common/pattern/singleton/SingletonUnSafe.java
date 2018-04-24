package com.rockydang.service.springdemo.common.pattern.singleton;

/**
 * 懒汉模式-线程不安全
 * Created by yanxiao on 2018/4/24.
 */
public class SingletonUnSafe {
    private static SingletonUnSafe instance;

    private SingletonUnSafe() {

    }

    // TODO: 2018/4/24 线程不安全的 
    public static SingletonUnSafe getInstance() {
        if (instance == null) {
            instance = new SingletonUnSafe();
        }
        return instance;
    }
}

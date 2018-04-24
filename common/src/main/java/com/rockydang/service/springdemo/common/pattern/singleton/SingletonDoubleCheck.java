package com.rockydang.service.springdemo.common.pattern.singleton;

/**
 * Created by yanxiao on 2018/4/24.
 */
public class SingletonDoubleCheck {
    private static SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {
    }

    public static synchronized SingletonDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}

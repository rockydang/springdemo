package com.rockydang.service.springdemo.common.pattern.singleton;

/**
 * 饿汉式记载方式
 * 通过classload机制避免了多线程同步问题,但是instance在类加载时实例化,没有达到lazy loading的效果,不推荐
 * <p>
 * Created by yanxiao on 2018/4/24.
 */
public class SingletonNoLazy {
    private static SingletonNoLazy instance;

    static {
        instance = new SingletonNoLazy();
    }

    private SingletonNoLazy() {

    }

    public static synchronized SingletonNoLazy getInstance()
    {
        return instance;
    }
}

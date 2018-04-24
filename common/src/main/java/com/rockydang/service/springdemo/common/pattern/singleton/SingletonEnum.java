package com.rockydang.service.springdemo.common.pattern.singleton;

/**
 * 这种方式是Effective Java作者Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象，可谓是很坚强的壁垒啊，推荐！
 * Created by yanxiao on 2018/4/24.
 */
public enum SingletonEnum {
    INSTANCE;

    public void whateverMethod() {
        System.out.println("aaaa");
    }
}

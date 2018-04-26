package com.rockydang.service.springdemo.common.pattern.observer;

/**
 * 观察者对象
 *
 * @author yanxiao  on 2018/4/26.
 */
public class User implements Observer {

    String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String message) {
        System.out.println(userName + ",接到消息:" + message);
    }
}

package com.rockydang.service.springdemo.common.pattern.proxy;

/**
 * 动态代理之静态代理-实际对象
 * <p>
 * Created by yanxiao on 2018/4/26.
 */
public class RealSubject implements Subject {

    @Override
    public void visit() {
        System.out.println("RealSubject#visit...");
    }
}
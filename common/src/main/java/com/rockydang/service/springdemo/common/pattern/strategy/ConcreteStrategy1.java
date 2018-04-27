package com.rockydang.service.springdemo.common.pattern.strategy;

/**
 * 策略模式-具体策略
 * Created by yanxiao on 2018/4/26.
 */
public class ConcreteStrategy1 implements Strategy {

    @Override
    public void strategyInterface() {
        System.out.println("ConcreteStrategy1 strategyInterface...");
    }
}

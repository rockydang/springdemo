package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class Aircraft implements Flyable {

    @Override
    public void fly(int height) {
        System.out.println("我是客机,可以飞" + height + "米高。");
    }
}

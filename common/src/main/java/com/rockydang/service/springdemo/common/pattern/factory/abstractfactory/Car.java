package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class Car implements Moveable {
    @Override
    public void run(int metre) {
        System.out.println("我是一辆小汽车,可以跑" + metre + "公里远。");
    }
}

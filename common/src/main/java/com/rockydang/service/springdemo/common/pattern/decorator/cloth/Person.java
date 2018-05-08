package com.rockydang.service.springdemo.common.pattern.decorator.cloth;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class Person implements Human {

    @Override
    public void wearClothes() {
        System.out.println("穿什么。。。");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪儿。。。");
    }
}

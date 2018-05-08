package com.rockydang.service.springdemo.common.pattern.decorator.humburger;

/**
 * 鸡肉汉堡
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class ChickenHumburger extends Humburger {

    public ChickenHumburger() {
        name = "鸡腿堡";
    }

    @Override
    public double getPrice() {
        return 10;
    }
}

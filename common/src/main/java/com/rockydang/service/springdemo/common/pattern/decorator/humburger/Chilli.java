package com.rockydang.service.springdemo.common.pattern.decorator.humburger;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class Chilli extends Condiment {

    Humburger humburger;

    public Chilli(Humburger humburger) {
        this.humburger = humburger;
    }

    @Override
    public String getName() {
        return humburger.getName() + ",加辣椒";
    }

    @Override
    public double getPrice() {
        return humburger.getPrice() + 1;
    }
}

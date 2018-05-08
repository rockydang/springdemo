package com.rockydang.service.springdemo.common.pattern.decorator.humburger;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class Lettuce extends Condiment {

    Humburger humburger;

    public Lettuce(Humburger humburger) {
        this.humburger = humburger;
    }

    @Override
    public String getName() {
        return humburger.getName() + ",加生菜";
    }

    @Override
    public double getPrice() {
        return humburger.getPrice() + 1.2;
    }
}

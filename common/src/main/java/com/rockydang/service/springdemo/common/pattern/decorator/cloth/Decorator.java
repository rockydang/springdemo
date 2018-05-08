package com.rockydang.service.springdemo.common.pattern.decorator.cloth;

/**
 * Created by yanxiao on 2018/5/8.
 */
public abstract class Decorator implements Human {
    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }

    @Override
    public void walkToWhere() {
        human.walkToWhere();
    }
}

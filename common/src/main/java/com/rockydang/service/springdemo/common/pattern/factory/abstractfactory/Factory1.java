package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class Factory1 extends AbstractFactory {
    @Override
    public Flyable createFlyable() {
        return new Aircraft();
    }

    @Override
    public Moveable createMoveable() {
        return new Car();
    }

    @Override
    public Writeable createWriteable() {
        return new Pen();
    }
}

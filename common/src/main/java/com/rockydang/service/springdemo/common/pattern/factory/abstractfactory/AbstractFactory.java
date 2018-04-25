package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public abstract class AbstractFactory {

    public abstract Flyable createFlyable();

    public abstract Moveable createMoveable();

    public abstract Writeable createWriteable();
}

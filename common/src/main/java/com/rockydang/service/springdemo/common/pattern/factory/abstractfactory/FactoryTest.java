package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new Factory1();

        //飞行器
        Flyable flyable = factory.createFlyable();
        flyable.fly(10);

        //小车
        Moveable moveable = factory.createMoveable();
        moveable.run(200);

        //笔
        Writeable writeable = factory.createWriteable();
        writeable.write("hello world.");
    }
}

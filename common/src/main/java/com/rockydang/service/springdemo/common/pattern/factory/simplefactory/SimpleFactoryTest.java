package com.rockydang.service.springdemo.common.pattern.factory.simplefactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Broom broom = (Broom) simpleFactory.create(Broom.class);
        broom.run();
    }
}

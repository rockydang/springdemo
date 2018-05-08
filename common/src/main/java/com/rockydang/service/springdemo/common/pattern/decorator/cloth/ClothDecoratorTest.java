package com.rockydang.service.springdemo.common.pattern.decorator.cloth;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class ClothDecoratorTest {

    public static void main(String[] args) {

        Human person = new Person();
        Decorator decorator = new Decorator_one(new Decorator_zero(person));
        decorator.walkToWhere();
        System.out.println("------");
        decorator.wearClothes();
    }
}

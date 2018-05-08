package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

/**
 * 咖啡装饰者测试类
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class CoffeDecoratorTest {

    public static void main(String[] args) {

        Berverage decafCoffe = new DecafCoffe();

        Berverage milk = new MilkDecorator(decafCoffe);
        System.out.println("milk:" + milk.getDescription() + ";cost:" + milk.getCost());

        Berverage moka = new MokaDecorator(decafCoffe);
        System.out.println("moka:" + moka.getDescription() + ";cost:" + moka.getCost());

        Berverage mokaMilk = new MokaDecorator(milk);
        System.out.println("mokaMilk:" + mokaMilk.getDescription() + ";cost:" + mokaMilk.getCost());

    }
}

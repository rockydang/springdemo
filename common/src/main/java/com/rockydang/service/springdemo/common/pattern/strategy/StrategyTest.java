package com.rockydang.service.springdemo.common.pattern.strategy;

/**
 * Created by yanxiao on 2018/4/26.
 */
public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategy1());
        context.contextInterface();

        Context context2 = new Context(new ConcreteStrategy2());
        context2.contextInterface();
    }
}

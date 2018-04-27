package com.rockydang.service.springdemo.common.pattern.strategy;

/**
 * 策略模式-环境策略类
 * <p>
 *
 * @author yanxiao  on 2018/4/26.
 */
public class Context {

    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.strategyInterface();
    }
}

package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

/**
 * 摩卡装饰类
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class MokaDecorator extends Berverage {

    Berverage berverage;

    public MokaDecorator(Berverage berverage) {
        super();
        this.berverage = berverage;
    }

    @Override
    public double getCost() {
        return berverage.getCost() + 1.9;
    }

    @Override
    public String getDescription() {
        return berverage.getDescription() + ",Moka";
    }
}

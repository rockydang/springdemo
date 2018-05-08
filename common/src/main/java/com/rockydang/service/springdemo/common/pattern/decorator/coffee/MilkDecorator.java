package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

/**
 * 牛奶咖啡装饰类
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class MilkDecorator extends CondimentDecorator {

    Berverage berverage;

    public MilkDecorator(Berverage berverage) {
        super();
        this.berverage = berverage;
    }

    @Override
    public double getCost() {
        return berverage.getCost() + 2.9;
    }

    @Override
    public String getDescription() {
        return berverage.getDescription() + ",Milk";
    }
}

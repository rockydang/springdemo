package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

/**
 * 脱因咖啡
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public class DecafCoffe extends Berverage {

    public DecafCoffe() {
        super();
        description = "DecafCoffe";
    }

    @Override
    public double getCost() {
        return 8.12;
    }
}

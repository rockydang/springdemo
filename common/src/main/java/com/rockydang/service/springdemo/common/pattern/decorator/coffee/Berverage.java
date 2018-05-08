package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

import lombok.Getter;

/**
 * 饮料基类
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public abstract class Berverage {

    @Getter
    String description;

    /**
     * 获取价格
     *
     * @return
     */
    public abstract double getCost();
}

package com.rockydang.service.springdemo.common.pattern.decorator.humburger;

import lombok.Getter;

/**
 * Humber基类
 *
 * Created by yanxiao on 2018/5/8.
 */
public abstract class Humburger {

    @Getter
    String name;

    public abstract double getPrice();
}

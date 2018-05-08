package com.rockydang.service.springdemo.common.pattern.decorator.coffee;

/**
 * 佐料装饰类
 * <p>
 * Created by yanxiao on 2018/5/8.
 */
public abstract class CondimentDecorator extends Berverage {

    /**
     * 提供一个必须实现的描述接口方便观察结果
     *
     * @return
     */
    @Override
    public abstract String getDescription();
}

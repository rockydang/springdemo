package com.rockydang.service.springdemo.common.pattern.factory.abstractfactory;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class Pen implements Writeable {

    @Override
    public void write(String content) {

        System.out.println("我是一只钢笔,刚刚写下了:" + content);
    }
}

package com.rockydang.service.springdemo.common.callback.example1;

/**
 * Created by yanxiao on 16/4/14.
 */
public class Boss implements  CallBackInterface {

    @Override
    public void execute() {
        System.out.println("get-->"+System.currentTimeMillis());
    }
}

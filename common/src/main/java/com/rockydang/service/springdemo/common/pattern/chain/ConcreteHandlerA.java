package com.rockydang.service.springdemo.common.pattern.chain;

/**
 * Created by yanxiao on 2018/4/27.
 */
public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(this.getClass() + "  处理请求  " + request);
        }else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

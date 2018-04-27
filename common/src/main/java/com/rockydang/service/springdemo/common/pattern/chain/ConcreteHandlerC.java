package com.rockydang.service.springdemo.common.pattern.chain;

/**
 * Created by yanxiao on 2018/4/27.
 */
public class ConcreteHandlerC extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(this.getClass() + "  处理请求  " + request);
        }else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

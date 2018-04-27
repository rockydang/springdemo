package com.rockydang.service.springdemo.common.pattern.chain;

/**
 * 责任链处理Handler
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public abstract class Handler {
    protected Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}

package com.rockydang.service.springdemo.common.pattern.proxy.statics;

import com.rockydang.service.springdemo.common.pattern.proxy.Subject;

/**
 * 代理模式之静态代理:代理类
 * Created by yanxiao on 2018/4/26.
 */
public class StaticProxySubject implements Subject {

    Subject subject;

    public StaticProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}

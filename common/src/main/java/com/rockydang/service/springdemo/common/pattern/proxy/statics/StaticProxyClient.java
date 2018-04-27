package com.rockydang.service.springdemo.common.pattern.proxy.statics;

import com.rockydang.service.springdemo.common.pattern.proxy.RealSubject;

/**
 * 代理模式之静态代理-测试类
 * <p>
 *
 * @author yanxiao on 2018/4/26.
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        StaticProxySubject staticProxySubject = new StaticProxySubject(new RealSubject());
        staticProxySubject.visit();
    }
}

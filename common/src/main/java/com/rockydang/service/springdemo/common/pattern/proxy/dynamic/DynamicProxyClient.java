package com.rockydang.service.springdemo.common.pattern.proxy.dynamic;

import com.rockydang.service.springdemo.common.pattern.proxy.RealSubject;
import com.rockydang.service.springdemo.common.pattern.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * 代理模式之动态代理-代理类测试
 * <p>
 * Created by yanxiao on 2018/4/26.
 */
public class DynamicProxyClient {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();

        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader,
                new  Class[]{Subject.class}, dynamicProxy);

        subject.visit();
    }
}

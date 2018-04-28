package com.rockydang.service.springdemo.common.pattern.adaptor.defaultadaptor;

/**
 * 具体适配器实现
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public class ConcreteAdaptorService extends AbstractAdaptorService {

    @Override
    public String serviceOperation3() {
        System.out.println("ConcreteAdaptorService#serviceOperation3 start...");
        return null;
    }
}
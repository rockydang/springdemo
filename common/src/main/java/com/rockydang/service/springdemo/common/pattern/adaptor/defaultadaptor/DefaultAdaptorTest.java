package com.rockydang.service.springdemo.common.pattern.adaptor.defaultadaptor;

/**
 * 缺省适配器测试
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public class DefaultAdaptorTest {

    public static void main(String[] args) {

        ConcreteAdaptorService adaptorService = new ConcreteAdaptorService();
        adaptorService.serviceOperation1();
        adaptorService.serviceOperation2();
        adaptorService.serviceOperation3();
    }
}

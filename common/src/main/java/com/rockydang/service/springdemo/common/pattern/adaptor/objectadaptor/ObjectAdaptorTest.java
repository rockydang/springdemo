package com.rockydang.service.springdemo.common.pattern.adaptor.objectadaptor;

import com.rockydang.service.springdemo.common.pattern.adaptor.Adaptee;

/**
 * 对象适配器测试类
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public class ObjectAdaptorTest {

    public static void main(String[] args) {
        ObjectAdaptor objectAdaptor = new ObjectAdaptor(new Adaptee());
        objectAdaptor.sampleOperation1();
        objectAdaptor.sampleOperation2();
    }
}

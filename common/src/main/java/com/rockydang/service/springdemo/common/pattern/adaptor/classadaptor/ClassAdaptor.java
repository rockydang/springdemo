package com.rockydang.service.springdemo.common.pattern.adaptor.classadaptor;

import com.rockydang.service.springdemo.common.pattern.adaptor.Adaptee;
import com.rockydang.service.springdemo.common.pattern.adaptor.Target;

/**
 * 类适配器
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public class ClassAdaptor extends Adaptee implements Target {

    @Override
    public void sampleOperation2() {
        System.out.println("ClassAdaptor#sampleOperation2 ...");
    }
}

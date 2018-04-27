package com.rockydang.service.springdemo.common.pattern.adaptor.objectadaptor;

import com.rockydang.service.springdemo.common.pattern.adaptor.Adaptee;

/**
 * 对象适配器
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public class ObjectAdaptor {

    Adaptee adaptee;

    public ObjectAdaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    public void sampleOperation1() {
        this.adaptee.sampleOperation1();
    }

    /**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
    public void sampleOperation2() {
        System.out.println("ObjectAdaptor#sampleOperation2...");
    }
}

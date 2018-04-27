package com.rockydang.service.springdemo.common.pattern.adaptor;

/**
 * 对象适配器-目标接口
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();

    /**
     * 这是源类Adapteee没有的方法
     */
    void sampleOperation2();

}

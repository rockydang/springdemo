package com.rockydang.service.springdemo.common.pattern.adaptor.defaultadaptor;

/**
 * 适配器类
 * <p>
 * Created by yanxiao on 2018/4/27.
 */
public abstract class AbstractAdaptorService implements BaseAdaptorService {
    @Override
    public void serviceOperation1() {
        System.out.println("AbstractAdaptorService#serviceOperation1 ...");
    }


    @Override
    public int serviceOperation2() {
        System.out.println("AbstractAdaptorService#serviceOperation2 ...");
        return 0;
    }

    @Override
    public String serviceOperation3() {
        System.out.println("AbstractAdaptorService#serviceOperation3 ...");
        return null;
    }
}

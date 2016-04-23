package com.rockydang.service.springdemo.web.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yanxiao on 16/4/12.
 */
@Component
public class BeanTest {

    public BeanTest() {
        System.out.println("Creating bean BeanTest...");
    }

    private BeanTest1 beanTest1;
    private BeanTest2 beanTest2;

    public BeanTest1 getBeanTest1() {
        return beanTest1;
    }

    @Autowired
    public void setBeanTest1(BeanTest1 beanTest1) {
        System.out.println("BeanTest setting bean reference for BeanTest1");
        this.beanTest1 = beanTest1;
    }

    public BeanTest2 getBeanB() {
        return beanTest2;
    }

    @Autowired
    public void setBeanTest2(BeanTest2 beanTest2) {
        System.out.println("BeanTest setting bean reference for BeanTest2");
        this.beanTest2 = beanTest2;
    }
}

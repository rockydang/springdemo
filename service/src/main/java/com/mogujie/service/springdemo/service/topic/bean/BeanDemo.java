package com.mogujie.service.springdemo.service.topic.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yanxiao on 16/4/12.
 */
@Component
public class BeanDemo {

    public BeanDemo() {
        System.out.println("Creating bean BeanDemo...");
    }

    private BeanA beanA;
    private BeanB beanB;

    public BeanA getBeanA() {
        return beanA;
    }

    @Autowired
    public void setBeanA(BeanA beanA) {
        System.out.println("BeanDemo setting bean reference for BeanA");
        this.beanA = beanA;
    }

    public BeanB getBeanB() {
        return beanB;
    }

    @Autowired
    public void setBeanB(BeanB beanB) {
        System.out.println("BeanDemo setting bean reference for BeanB");
        this.beanB = beanB;
    }
}

package com.rockydang.service.springdemo.service.bean;

import com.rockydang.service.springdemo.service.GuavaLocalLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yanxiao on 16/4/12.
 */
@Component
public class BeanB {
    public BeanB() {
        System.out.println("init BeanB....");
    }

    GuavaLocalLoadService guavaLocalLoadService;

    BeanDemo beanDemo;

    @Autowired
    public void setGuavaLocalLoadService(GuavaLocalLoadService guavaLocalLoadService) {
        System.out.println("BeanB --> guavaLocalLoadService....");
        this.guavaLocalLoadService = guavaLocalLoadService;
    }

    @Autowired
    public void setBeanDemo(BeanDemo beanDemo) {
        System.out.println("BeanB --> beanDemo....");
        this.beanDemo = beanDemo;
    }
}

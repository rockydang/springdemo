package com.rockydang.service.springdemo.service.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * 文件描述。
 *
 * @author yanxiao[.'
 * @since 2016年10月04日 11:10
 */
public class MyBeanPostProcessor2 implements BeanPostProcessor, Ordered {

    public MyBeanPostProcessor2() {
        System.out.println("instantiation MyBeanPostProcessor2...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke MyBeanPostProcessor2.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("invoke MyBeanPostProcessor2.postProcessAfterInitialization");
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

package com.rockydang.service.springdemo.service.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年10月04日 16:28
 */
public class MyBeanFacotryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFacotryPostProcessor(){
        System.out.println("instantion MyBeanFacotryPostProcessor...");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition bd = beanFactory.getBeanDefinition("car");

//        bd.getPropertyValues().addPropertyValue("brand", "Audi");

        System.out.println("invoke BeanFactoryPostProcessor.postProcessBeanFactory Factory...");
    }
}

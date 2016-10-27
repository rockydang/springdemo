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
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    public MyBeanPostProcessor() {
        System.out.println("instantiation MyBeanPostProcessor...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("invoke BeanPostProcessor.postProcess " +
                        "BeforeInitialization(),color is null and set color is black..");
                car.setColor("black");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() > 200) {
                System.out.println("invoke BeanPostProcessor.postProcess " +
                        "AfterInitialization(),the maxSpeed is " + car.getMaxSpeed() + "; reset maxSpeed is 200...");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

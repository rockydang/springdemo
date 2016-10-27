package com.rockydang.service.springdemo.service.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Date;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年10月04日 10:45
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, ApplicationContextAware {

    private String brand;

    private String color;

    private int maxSpeed;

    private Date dateValue;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("invoke Car的构造函数...");
    }

    public void setBrand(String brand) {
        System.out.println("invoke Car.setBrand()...");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public void introduce() {
        System.out.println("invoke Car.introduce(); brand:" + brand + ";color:" + color
                + ";maxSpeed:" + maxSpeed+";dateValue:"+dateValue.getTime());
    }

    //BeanFactoryAware 接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("invoke BeanFactoryAware.setBeanFactory...");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware 接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("invoke BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    //DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destory()");
    }

    //InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("invoke InitializingBean.afterPropertiesSet()");
    }

    //通过<bean>的init-method属性指定初始化方法
    public void myInit() {
        System.out.println("invoke <bean>指定的myInit()... maxSpeed is 240...");
        this.maxSpeed = 240;
    }

    //通过<bean>的destory-method属性指定销毁方法
    public void myDestroy() {
        System.out.println("invoke <bean>指定的myDestroy...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("invoke Car.setApplicationContext()...");
    }
}

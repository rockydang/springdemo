package com.rockydang.service.springdemo.service.lifecycle.beanfactory;

import com.rockydang.service.springdemo.service.lifecycle.Car;
import com.rockydang.service.springdemo.service.lifecycle.MyBeanPostProcessor;
import com.rockydang.service.springdemo.service.lifecycle.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * BeanFactory 生命周期演示;
 *
 * @author yanxiao
 * @since 2016年10月04日 15:41
 */
public class BeanLifeCycle {

    private static void lifeCycleInBeanFactory() {
        //1.装载配置文件并启动容器
        Resource res = new ClassPathResource("spring/spring-lifecycle_beanfactory.xml");
        BeanFactory bf = new XmlBeanFactory(res);

        //2.向容器中注册MybeanPostProessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //3.向容器注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //4.第一次从容器中获取car,将触发容器实例化该bean,这会引发Bean生命周期方法的调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("red");

        //5.由于bean是singleton，直接从缓存池中获取；
        Car car2 = (Car) bf.getBean("car");

        //6.比较是否为同一引用；
        System.out.println("car1==car2:" + (car1 == car2));

        //7.关闭容器
        ((XmlBeanFactory) bf).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}

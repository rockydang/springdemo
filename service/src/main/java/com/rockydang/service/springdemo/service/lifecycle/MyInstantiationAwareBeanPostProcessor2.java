package com.rockydang.service.springdemo.service.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.Ordered;

import java.beans.PropertyDescriptor;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年10月04日 11:10
 */
public class MyInstantiationAwareBeanPostProcessor2 extends InstantiationAwareBeanPostProcessorAdapter implements Ordered {

    public MyInstantiationAwareBeanPostProcessor2(){
        System.out.println("instantiation MyInstantiationAwareBeanPostProcessor");
    }

    //1.接口方法：在实例化Bean前调用
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        //仅对car处理
        if ("car".equals(beanName)) {
            System.out.println("invoke InstantiationAwareBeanPostProcessorAdapter2222.postProcessBeforeInstantiation..");
        }
        return null;
    }

    //2.接口方法：在实例化Bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("invoke InstantiationAwareBeanPostProcessorAdapter2222.postProcessAfterInstantiation");
        }
        return true;
    }

    //3.接口方法：在设置某个属性时调用
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        //仅对容器中的carBean进行处理，还可以通过pds入参进行过滤
        //仅对car的某个特定属性时进行处理
        if ("car".equals(beanName)) {
            System.out.println("invoke InstantiationAwareBeanPostProcessorAdapter2222.postProcessPropertyValues");
        }
        return pvs;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

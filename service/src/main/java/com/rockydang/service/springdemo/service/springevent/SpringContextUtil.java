package com.rockydang.service.springdemo.service.springevent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 可以使没有被spring管理的类调用到bean
 * 一定要在spring.xml中加上:
 * <bean id="SpringContextUtil " class="com.mogujie.scrolls.client.util.SpringContextUtil " singleton="true" />
 * 当对SpringContextUtil实例时就自动设置applicationContext,以便后来可直接用applicationContext
 * <p>
 * Created by suian on 16/4/25.
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 根据beanName(对应于Bean配置的Id属性）获取Bean对象
     *
     * @param beanName
     * @return
     */
    public final static Object getBean(String beanName) throws BeansException {
        return SpringContextUtil.applicationContext.getBean(beanName);
    }

    /**
     * 根据bean的class类型获取bean对象
     *
     * @param clazz
     * @return
     */
    public final static Object getBean(Class clazz) throws BeansException {
        return SpringContextUtil.applicationContext.getBean(clazz);
    }

    /**
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name         bean注册名
     * @param requiredType 返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
    public static Object getBean(String name, Class requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * 返回注册对象的类型
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }
}

package com.rockydang.service.springdemo.service.springevent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanxiao on 2016/10/23.
 */
public class TestSpringEvent {

    public static void main(String[] args) {

        TestEventDO testEventDO = new TestEventDO();
        testEventDO.setId("12");
        testEventDO.setName("test...");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-lifecycle_applicationcontext.xml");
//        applicationContext.publishEvent(new SubTaskFinishEvent(testEventDO));

        SpringContextUtil springContextUtil = (SpringContextUtil) applicationContext.getBean("SpringContextUtil");

        springContextUtil.getApplicationContext().publishEvent(new SubTaskFinishEvent(testEventDO));
    }
}

package com.rockydang.service.springdemo.service.impl;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Creator: qiaoyu
 * Desc: AbstractBootStrapTest
 * Date: 15/12/25
 */
public abstract class AbstractBootStrapTest {
    protected GenericXmlApplicationContext context = new GenericXmlApplicationContext();

    @Before
    public void init() throws Exception {
        context.load("classpath*:spring/spring-*.xml");
        context.refresh();
    }

    @After
    public void destroy() {
        context.destroy();
    }
}

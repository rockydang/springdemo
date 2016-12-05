package com.rockydang.service.springdemo.service.proxy.util;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月11日 21:46
 */
public class GeneratorClass {


    public void generatorCglibClass(Object object) {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yanxiao/proxydev/aa.class");
    }
}

package com.rockydang.service.springdemo.service.proxy.cglibproxy;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:43
 */
public class TestCglib {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/yanxiao/proxydev/");
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeCglibImpl bookCglib = (BookFacadeCglibImpl) cglib.getInstance(new BookFacadeCglibImpl());
        System.out.println("className=" + bookCglib.getClass().getName());



        bookCglib.addBook();
    }
}

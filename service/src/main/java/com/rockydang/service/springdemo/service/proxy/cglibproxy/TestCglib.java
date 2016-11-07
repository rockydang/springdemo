package com.rockydang.service.springdemo.service.proxy.cglibproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:43
 */
public class TestCglib {
    public static void main(String[] args) {
        BookFacadeCglib cglib = new BookFacadeCglib();
        BookFacadeCglibImpl bookCglib = (BookFacadeCglibImpl) cglib.getInstance(new BookFacadeCglibImpl());
        bookCglib.addBook();
    }
}

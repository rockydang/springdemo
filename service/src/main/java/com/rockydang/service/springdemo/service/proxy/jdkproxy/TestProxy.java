package com.rockydang.service.springdemo.service.proxy.jdkproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:40
 */
public class TestProxy {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }
}

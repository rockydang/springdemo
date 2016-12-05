package com.rockydang.service.springdemo.service.proxy.jdkproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:40
 */
public class BookFacadeImpl1 implements BookFacade1 {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }

}

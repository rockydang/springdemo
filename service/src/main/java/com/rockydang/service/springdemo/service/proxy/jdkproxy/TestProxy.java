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
//        BookFacadeProxy proxy1 = new BookFacadeProxy();

        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        System.out.println("bookProxy==" + bookProxy.getClass().getName());
        bookProxy.addBook();

   /*   BookFacade1 bookProxy1 = (BookFacade1) proxy1.bind(new BookFacadeImpl1());
        bookProxy1.addBook();
        System.out.println("bookProxy1==" + bookProxy1.getClass().getName());*/

        //BookFacade bookProxy2 = (BookFacade) proxy1.bind(new BookFacadeImpl());
        //System.out.println("bookProxy2==" + bookProxy2.getClass().getName());

        //BookFacade1 bookProxy3 = (BookFacade1) proxy1.bind(new BookFacadeImpl1());
        //System.out.println("bookProxy3==" + bookProxy3.getClass().getName());
    }
}

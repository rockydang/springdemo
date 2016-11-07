package com.rockydang.service.springdemo.service.proxy.staticproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:21
 */
public class TestCount {
    public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();

        countProxy.queryCount();

    }
}

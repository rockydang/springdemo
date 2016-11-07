package com.rockydang.service.springdemo.service.proxy.staticproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:20
 */
public class CountImpl implements Count {

    @Override
    public void queryCount() {
        System.out.println("queryCount...");
    }

    @Override
    public void updateCount() {
        System.out.println("updateCount...");
    }
}

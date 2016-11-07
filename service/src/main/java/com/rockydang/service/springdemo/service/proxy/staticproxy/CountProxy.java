package com.rockydang.service.springdemo.service.proxy.staticproxy;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月07日 20:20
 */
public class CountProxy implements Count {
    private CountImpl countImpl;

    /**
     * 覆盖默认构造器
     *
     * @param countImpl
     */
    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("queryCount before...");
        // 调用委托类的方法;
        countImpl.queryCount();
        System.out.println("queryCount after...");
    }

    @Override
    public void updateCount() {
        System.out.println("updateCount before...");
        // 调用委托类的方法;
        countImpl.updateCount();
        System.out.println("updateCount after...");
    }
}

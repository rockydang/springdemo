package com.rockydang.service.springdemo.common.pattern.observer;

/**
 * 观察者模式测试类
 * <p>
 * Created by yanxiao on 2018/4/26.
 */
public class ObserverTest {

    public static void main(String[] args) {

        WechatServer wechatServer = new WechatServer();

        User user1 = new User("张三");
        wechatServer.registerObserver(user1);

        User user2 = new User("李四");
        wechatServer.registerObserver(user2);

        User user3 = new User("王五");
        wechatServer.registerObserver(user3);
        wechatServer.setInformation("PHP is the best language in the world.");
        wechatServer.notifyObserver();

        System.out.println("-------------------------");
        wechatServer.setInformation("nonono... Java is the best language in the world.");
        wechatServer.removeObserver(user2);
        wechatServer.notifyObserver();
    }
}

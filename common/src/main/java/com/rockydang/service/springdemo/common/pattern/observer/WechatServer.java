package com.rockydang.service.springdemo.common.pattern.observer;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号服务端
 * <p>
 *
 * @author yanxiao  on 2018/4/26.
 */
public class WechatServer implements Observerable {

    List<Observer> observers;

    String message;

    public WechatServer() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if (CollectionUtils.isEmpty(observers)) {
            return;
        }
        observers.forEach(observerItem -> observerItem.update(message));
    }

    public void setInformation(String message) {
        System.out.println("wechat server msg update.");
        this.message = message;
    }
}

package com.rockydang.service.springdemo.common.pattern.observer;

/**
 * 观察者模式_被观察者接口
 *
 * @author yanxiao  on 2018/4/26.
 */
public interface Observerable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
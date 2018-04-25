package com.rockydang.service.springdemo.common.pattern.factory.factorymethod;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class PlaneFactory extends VehicleFactory {
    @Override
    public Moveable createMoveable() {
        return new Plane();
    }
}

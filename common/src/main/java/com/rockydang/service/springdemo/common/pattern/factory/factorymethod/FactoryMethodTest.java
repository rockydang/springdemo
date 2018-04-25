package com.rockydang.service.springdemo.common.pattern.factory.factorymethod;

/**
 * Created by yanxiao on 2018/4/25.
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
//        VehicleFactory vehicleFactory = new BroomFactory();
        VehicleFactory vehicleFactory = new PlaneFactory();
        Moveable moveable = vehicleFactory.createMoveable();
        moveable.run();
        ;
    }
}

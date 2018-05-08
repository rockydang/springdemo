package com.rockydang.service.springdemo.common.pattern.decorator.humburger;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class HumburgerTest {

    public static void main(String[] args) {

        Humburger chikenHumber = new ChickenHumburger();

        Chilli chilli = new Chilli(chikenHumber);
        Lettuce lettuce = new Lettuce(chilli);

        System.out.println("lettuce:" + lettuce.getName() + ";price:" + lettuce.getPrice());
    }
}

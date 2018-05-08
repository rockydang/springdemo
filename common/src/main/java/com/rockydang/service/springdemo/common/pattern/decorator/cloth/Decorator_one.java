package com.rockydang.service.springdemo.common.pattern.decorator.cloth;

/**
 * Created by yanxiao on 2018/5/8.
 */
public class Decorator_one extends Decorator {


    public Decorator_one(Human human) {
        super(human);
    }

    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }

    @Override
    public void wearClothes() {
        // TODO Auto-generated method stub
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        // TODO Auto-generated method stub
        super.walkToWhere();
        findPlaceOnMap();
    }
}

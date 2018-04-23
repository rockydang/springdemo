package com.rockydang.service.springdemo.common.jvmtest;

/**
 * Created by yanxiao on 2018/3/3.
 */
public class MyTest {
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2= 10;
        System.out.println(i1 == i2);


        Integer ii1 = new Integer(10);
        Integer ii2= new Integer(10);
        System.out.println(ii1==ii2);

        Integer i3 = 199;
        Integer i4= 199;
        System.out.println(i3==i4);
    }
}

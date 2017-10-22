package com.rockydang.service.springdemo.common.jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanxiao on 2017/2/21.
 */
public class TestJVM {

    public static void main(String[] args) {
        List list = new ArrayList();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}

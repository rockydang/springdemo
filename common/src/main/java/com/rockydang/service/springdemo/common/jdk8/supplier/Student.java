package com.rockydang.service.springdemo.common.jdk8.supplier;

import lombok.Data;

/**
 * Created by yanxiao on 2017/6/11.
 */
@Data
public class Student {

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }


    String name = "111";
}

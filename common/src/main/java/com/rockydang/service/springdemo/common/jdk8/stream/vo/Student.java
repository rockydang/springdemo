package com.rockydang.service.springdemo.common.jdk8.stream.vo;

import lombok.Data;

/**
 * Created by yanxiao on 2017/8/29.
 */
@Data
public class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {

    }
}

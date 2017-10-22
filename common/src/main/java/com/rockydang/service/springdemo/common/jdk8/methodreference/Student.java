package com.rockydang.service.springdemo.common.jdk8.methodreference;

import lombok.Data;

/**
 * Created by yanxiao on 2017/6/15.
 */
@Data
public class Student {

    private String name;
    private int score;

    public static int compareByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public static int compareByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}

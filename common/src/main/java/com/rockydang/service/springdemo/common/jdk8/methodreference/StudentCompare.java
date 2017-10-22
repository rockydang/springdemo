package com.rockydang.service.springdemo.common.jdk8.methodreference;

/**
 * Created by yanxiao on 2017/6/15.
 */
public class StudentCompare {
    public int compareByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public int compareByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}

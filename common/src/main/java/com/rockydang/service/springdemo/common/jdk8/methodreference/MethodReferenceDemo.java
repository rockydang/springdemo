package com.rockydang.service.springdemo.common.jdk8.methodreference;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by yanxiao on 2017/6/14.
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
       /* List<String> list = Lists.newArrayList("a", "b", "c");
        list.forEach(item -> System.out.println(item));
        System.out.println("--------------------------");
        list.forEach(System.out::println);*/

        System.out.println("-----------------------");

        Student student1 = new Student();
        student1.setName("zhangsan");
        student1.setScore(20);

        Student student2 = new Student();
        student2.setName("lisi");
        student2.setScore(10);

        Student student3 = new Student();
        student3.setName("wangwu");
        student3.setScore(30);


        List<Student> students = Lists.newArrayList(student1, student2, student3);

        //1.静态方法引用
      /*  students.sort((s1, s2) -> Student.compareByName(s1, s2));
        students.sort(Student::compareByScore);
        students.forEach(System.out::println);*/

        //2.实例方法引用
        StudentCompare studentCompare = new StudentCompare();
        students.sort((s1, s2) -> studentCompare.compareByScore(s1, s2));
        System.out.println("-----");
//        students.sort(studentCompare::compareByScore);
        students.forEach(System.out::println);
    }
}

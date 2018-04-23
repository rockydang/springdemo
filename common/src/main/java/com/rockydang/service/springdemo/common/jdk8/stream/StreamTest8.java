package com.rockydang.service.springdemo.common.jdk8.stream;


import com.rockydang.service.springdemo.common.jdk8.stream.vo.Student;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * flatMap
 */
public class StreamTest8 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<String> list = Arrays.asList("hello world", "world welcome", "welcome welcome");

     /*   list.stream().map(item -> Arrays.asList(item.split(" ")))
                .distinct().collect(Collectors.toList()).forEach(System.out::println);*/


        /*list.stream().map(item -> item.split(" "))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::println);*/

        StreamTest8 streamTest8 = new StreamTest8();
        streamTest8.test();
    }

    private void test() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("aa");
        student.setAge(1);
        students.add(student);

        student = new Student();
        student.setName("bb");
        student.setAge(2);
        students.add(student);

        student = new Student();
        student.setName("cc");
        student.setAge(1);
        students.add(student);

        List<Student> students1 = new ArrayList<>();
        students.stream().collect(
                Collectors.groupingBy(Student::getAge))
                .forEach((key, value) -> students1.add(value.get(0)));
        System.out.println(students1);

        students.stream().collect(
                Collectors.groupingBy(Student::getAge))
                .forEach((key, value) -> students1.add(value.get(0)));
    }
}

package com.rockydang.service.springdemo.common.jdk8.stream;

import com.rockydang.service.springdemo.common.jdk8.stream.vo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 分组功能
 * 类似与sql语句
 * <p>
 * Created by yanxiao on 2017/8/29.
 */
public class StreamTest10 {

    public static void main(String[] args) {
        Student student1 = new Student("zhang", 10, 80);
        Student student2 = new Student("zhang", 20, 90);
        Student student3 = new Student("li", 10, 80);
        List<Student> studentList = Arrays.asList(student1, student2, student3);

       /* //按名字分组
        Map<String, List<Student>> nameStudentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName));
        System.out.println(nameStudentMap);

        //按分数分组
        Map<Integer, List<Student>> scoreStudentMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getScore));
        System.out.println(scoreStudentMap);

        //按分数分组
        Map<Integer, Long> scoreCountMap = studentList.stream(
                .collect(Collectors.groupingBy(Student::getScore, Collectors.counting()));
        System.out.println(scoreCountMap);

        //按人名分组、分数求平均值
        Map<String, Double> avgScoreCountMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(avgScoreCountMap);*/

        //按人名分区、分数求平均值
        Map<Boolean, List<Student>> partitioningByMap = studentList.stream()
                .collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(partitioningByMap);
    }
}

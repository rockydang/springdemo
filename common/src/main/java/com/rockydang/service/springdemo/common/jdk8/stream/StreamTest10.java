package com.rockydang.service.springdemo.common.jdk8.stream;

import com.rockydang.service.springdemo.common.jdk8.stream.vo.Student;

import java.util.*;

import static java.util.stream.Collectors.*;

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

        //按名字分组
        Map<String, List<Student>> nameStudentMap = studentList.stream()
                .collect(groupingBy(Student::getName));
        System.out.println(nameStudentMap);
/*
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
                .collect(partitioningBy(student -> student.getScore() >= 90));
        System.out.println(partitioningByMap);

        System.out.println("#########################################");

        //获取分数最低的学生
        studentList.stream().collect(minBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        //获取分数最高的学生
        studentList.stream().collect(maxBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        //获取平均值
        System.out.println(studentList.stream().collect(averagingInt(Student::getScore)));
        //获取分数总和
        System.out.println(studentList.stream().collect(summingInt(Student::getScore)));

        //分析
        IntSummaryStatistics intSummaryStatistics = studentList.stream().collect(summarizingInt(Student::getScore));
        System.out.println(intSummaryStatistics);
        System.out.println("##################");

        System.out.println(studentList.stream().map(Student::getName).collect(joining()));
        System.out.println(studentList.stream().map(Student::getName).collect(joining(",")));
        System.out.println(studentList.stream().map(Student::getName).collect(joining(",", "<begin>", "<end>")));
        System.out.println("##################");
        Map<Integer, Map<String, List<Student>>> map =
                studentList.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(map);

        System.out.println("###############");
        Map<Boolean, List<Student>> booleanListMap =
                studentList.stream().collect(partitioningBy(student -> student.getScore() > 80));
        System.out.println(booleanListMap);
        System.out.println("###############");

        Map<Boolean, Map<Boolean, List<Student>>> map3 =
                studentList.stream().collect(
                        partitioningBy(studentItem -> studentItem.getScore() > 80, partitioningBy(studentItem -> studentItem.getScore() > 90)));
        System.out.println("map3=" + map3);

        Map<Boolean, Long> map4 =
                studentList.stream().collect(partitioningBy(student -> student.getScore() > 80, counting()));
        System.out.println(map4);
        System.out.println("-------------------------");

        Map<String, Student> map5 =
                studentList.stream().collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(map5);
    }


}

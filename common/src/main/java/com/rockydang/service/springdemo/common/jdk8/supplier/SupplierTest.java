package com.rockydang.service.springdemo.common.jdk8.supplier;

import java.util.function.Supplier;

/**
 * 不接受参数,返回结果
 * <p>
 * Created by yanxiao on 2017/6/11.
 */
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<String> stringSupplier = () -> "hello";
        System.out.println(stringSupplier.get());
        System.out.println("--------");

        Supplier<Student> studentSupplier = () -> new Student();
        System.out.println(studentSupplier.get().getName());
        System.out.println("---------");

        Supplier<Student> studentSupplier1 = Student::new;
        System.out.println(studentSupplier1.get().getName());
    }
}
package com.rockydang.service.springdemo.common.jdk8.optional;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("aa");

       /* if (optional.isPresent()) {
            System.out.println(optional.get());
        }*/
/*
        optional.ifPresent(item -> System.out.println(item));//推荐方式
        System.out.println(optional.orElse("aa"));
        System.out.println(optional.orElseGet(() -> "ccc"));

        System.out.println("---------------------------");*/

  /*      Company company = new Company();
        company.setName("a");

        Employee employee = new Employee();
        employee.setName("1");

        Employee employee1 = new Employee();
        employee1.setName("2");
        List<Employee> employees = Lists.newArrayList(employee, employee1);
//        company.setEmployees(employees);


        System.out.println(Optional.of(company).map(item -> item.getEmployees()).orElse(Collections.emptyList()));


        List<String> a =  Lists.newArrayList("a");

        List<String> couponInfoBeanList = Optional.ofNullable(a)
                .filter(item -> CollectionUtils.isNotEmpty(a))
                .orElse(Lists.newArrayList("111"));

        System.out.println(couponInfoBeanList);*/

        Employee employee = new Employee();
        employee.setName("bb");

        String name = "";
        if (employee != null) {
            name = Optional.ofNullable(employee.getName()).orElse("aaa");
        }
        System.out.println(name);
    }
}

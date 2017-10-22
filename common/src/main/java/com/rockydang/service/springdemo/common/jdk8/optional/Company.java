package com.rockydang.service.springdemo.common.jdk8.optional;

import lombok.Data;

import java.util.List;

/**
 * Created by yanxiao on 2017/6/14.
 */
@Data
public class Company {

    String name;

    List<Employee> employees;

}

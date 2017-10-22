package com.rockydang.service.springdemo.common.jdk8.test;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanxiao on 2017/6/7.
 */
public class TestLambda {

    public static void main(String[] args) {
        /*new Thread(() -> {
            System.out.println("111");
        }).start();

        List<String> list = Lists.newArrayList("1", "2", "2,3");


        //lambda表达式处理
        List<String> list2 = Lists.newArrayList();
        list.forEach(str -> {
            if (str.indexOf(",") != -1) {
                List<String> myList = new ArrayList<>(Arrays.asList(str.split(",")));
                list2.addAll(myList);
            } else {
                list2.add(str);
            }
        });
        System.out.println(list2);*/

        /*List<String> list2 = Lists.newArrayList();
        //stream
        List<String> list = Lists.newArrayList("1", "2", "2,3");
        list.stream().map(item -> {
            if (StringUtils.indexOf(item, ",") != -1) {
                return new ArrayList<>(Arrays.asList(item.split(",")));
            }
            return Lists.newArrayList(item);
        }).forEach(item -> list2.addAll(item));

        System.out.println(list2);*/


        //stream
        List<String> list = Lists.newArrayList("1", "2", "2,3");
        List<String> list2 = Lists.newArrayList();
        list.stream().map(item -> new ArrayList<>(Arrays.asList(item.split(",")))).forEach(item -> list2.addAll(item));
        System.out.println(list2);

        //方法引用




    }


    public static List<String> recurConvertList(List<String> list) {
        try {
            List<String> convertList = Lists.newArrayList();
            for (String idStr : list) {
                if (idStr.indexOf(",") != -1) {
                    List<String> myList = new ArrayList<>(Arrays.asList(idStr.split(",")));
                    convertList.addAll(myList);
                    continue;
                }
                convertList.add(idStr);
            }
            return convertList;
        } catch (Exception e) {
            return list;
        }
    }
}
package com.rockydang.service.springdemo.common.switchtest;

import java.util.Scanner;

import static com.rockydang.service.springdemo.common.switchtest.Day.MONDAY;
import static com.rockydang.service.springdemo.common.switchtest.Day.SUNDAY;
import static com.rockydang.service.springdemo.common.switchtest.Day.TUESDAY;

/**
 * Created by yanxiao on 2017/2/16.
 */
public class SwitchTest {

    Scanner s=new Scanner(System.in);

    String day=s.next();//输入的字符串

  /*  switch(Day.toDay(day.toUpperCase())){

        case SUNDAY:

            System.out.println("星期天");

            break;

        case MONDAY:

            System.out.println("星期一");

            break;

        case TUESDAY:

            System.out.println("星期二");

            break;

    }*/
}


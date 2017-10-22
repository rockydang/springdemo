package com.rockydang.service.springdemo.common.switchtest;

import java.util.Scanner;

/**
 * Created by yanxiao on 2017/2/16.
 */
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY,
    NOVALUE;

    public static Day toDay(String str) {
        try {
            return valueOf(str);
        } catch (Exception ex) {
            return NOVALUE;
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        String day=s.next();//������ַ���

        switch(Day.toDay(day.toUpperCase())){
            case SUNDAY:
                System.out.println("������");
                break;
            case MONDAY:
                System.out.println("����һ");
                break;
            case TUESDAY:
                System.out.println("���ڶ�");
                break;

        }
    }

    public void test(String status) {
        switch (status) {
            case "killed":
                break;
            case "alive":
                break;
            case "sacrificed":
                break;
            case "die":
                break;
            default:
                break;
        }
    }
}
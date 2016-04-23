package com.rockydang.service.springdemo.common.callback.example2;

/**
 * Created by yanxiao on 16/4/14.
 */
public class Test {


    public static void main(String[] args){
        Wang wang = new Wang(new Li());
        wang.askQuestion("今天什么日子。。。");
    }

}

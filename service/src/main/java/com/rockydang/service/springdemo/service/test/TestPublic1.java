package com.rockydang.service.springdemo.service.test;

/**
 * Created by yanxiao on 2017/1/9.
 * <p>
 * 文件名称为TestPublic1.java，文件名称与类名称不一致，但是因为使用了class声明所以，
 * 此时编译不会产生任何错误，但是生成之后的*.class文件的名称是和class声明的类名称完全一致的:TestPublic.class
 * 执行的时候不能再执行java TestPublic1，而是应该执行java TestPublic
 */
class TestPublic {
    public static void main(String[] args) {
        System.out.println("aadddd");
    }
}

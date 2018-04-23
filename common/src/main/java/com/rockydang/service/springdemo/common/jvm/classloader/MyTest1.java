package com.rockydang.service.springdemo.common.jvm.classloader;

/**
 * <p>问题:
 * 1.问什么通过MyTest1调用MyChild1.str1时,Mychild1的静态代码块没有执行?
 * 2.为什么调用Mychild1里直接定义的常量,str2的时候 MyParent1的静态代码块执行了?
 * <p>
 * 对于静态字段来说,只有直接定义了该字段的类才会被初始化;
 * <p>
 * 1.所有的Java虚拟机实现必须在每个类或接口被Java程序"首次主动使用"时才初始化他们；
 * 2.当一个类初始化时,其父类都要初始化完毕;
 * </p>
 * <p>
 * 用于追踪类的加载信息并打印出来: -XX:+TraceClassLoading
 * </p>
 *
 * @author yanxiao
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str1);
    }
}

class MyParent1 {
    public static String str1 = "hello world.";

    static {
        System.out.println("MyParent1 static block.");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "hello world. child";

    static {
        System.out.println("MyChild1 static block.");
    }
}
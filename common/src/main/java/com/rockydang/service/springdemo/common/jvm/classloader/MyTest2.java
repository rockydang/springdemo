package com.rockydang.service.springdemo.common.jvm.classloader;

/**
 * 疑问:1.为什么常量类的str加了final标识后, 常量块里不会输出了呢;
 * <p>
 * 常量在编译阶段会存入到调用这个常量的方法所在类的常量池中;
 * 本质上调用类并没有直接引用到定义常量的类,因此并不会触发定义常量类的初始化;
 * <p>
 * 注意: 这里值的是讲常量放到了MyTest2的常量池中,之后MyTest2与MyParent2就没关系了;
 * 甚至可以将MyParent2的class文件删除
 * </p>
 * <p>
 *     助记符
 *     ldc表示将int,float或是String类型的常量值从常量池中推送到栈顶;
 *     bipush表示将单字节(-128 ~ 127)的常量值推送到栈顶;
 *     sipush表示将一个短整型常量值(-32768 ~ 32767)推送至栈顶;
 *     iconst_1表示将int类型1推送至栈顶(iconst_1 ~ iconst_5)
 * </p>
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.m3);
    }
}

class MyParent2 {
    public static final String str = "hello world";
    public static final short s = 7;
    public static final int i =128;
    public static final int m =3;
    public static final Integer m3 = new Integer(3);
    static {
        System.out.println("MyParent2 static block.");
    }
}

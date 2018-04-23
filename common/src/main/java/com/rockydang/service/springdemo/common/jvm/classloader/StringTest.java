package com.rockydang.service.springdemo.common.jvm.classloader;

/**
 * Created by yanxiao on 2018/2/4.
 */
public class StringTest {

    public static void main(String[] args) {
        String a = new String();
        String a1 = new String("");
        System.out.println(a == a1);// false
        System.out.println(a.hashCode() == a1.hashCode());// true
        System.out.println(a.equals(a1));// true
        // 说明两者的哈希码是相同的，但是a==a1却是false，原因是两者在堆中的地址不一样，new出来
        // 的对象，放在堆中，而==是比较对象的地址是否一样


        /**
         * 在Java中，哈希码代表了对象的一种特征，例如我们判断某两个字符串是否==，如果其哈希码相
         * 等，则这两个字符串是相等的。
         * 其次，哈希码是一种数据结构的算法。常见的哈希码的算法有：
         * 1：Object类的hashCode
         * 返回对象的内存地址经过处理后的结构，由于每个对象的内存地址都不一样，所以哈希码也不一
         * 样。
         * Object的 equals方法return (this == obj),也就是==
         * 2：String类的hashCode
         * 根据String类包含的字符串的内容，根据一种特殊算法返回哈希码，只要字符串内容相同，返回
         * 的哈希码也相同。
         * String的 equals方法值相同返回true
         * 3：Integer类，返回的哈希码就是Integer对象里所包含的那个整数的数值
         * 例如Integer i1=new Integer(100),i1.hashCode的值就是100 。
         * 由此可见，2个一样大小的Integer对象，返回的哈希码也一样。
         */
        String b=new String ("123");
        String b1=new String("123");
        System.out.println(b==b1);//false
        System.out.println(b.hashCode()==b1.hashCode());// true
        // 这里说明一点对象的引用是放在栈stack内容中的，引用是一个指向，并不是一个对象，另外对象
        // 是放在堆heap内存中的

        /**
         * 这里说明下，c是对象引用，c1,c2也是对象引用，都放在栈中，但是不同的是，他们指向的位置，
         * 前者指向的是堆内存，当new一个对象时，CPU就会为其开辟一个空间，然后再新建一个
         * 字符串"123",而这个字符串不是放在String常量池中的，所谓String常量池是一个区域，
         * 这个区域存放的是所有字符串常量，这些字符串常量都不重复，它们供程序调用，例如下面一段
         * 程序，c1,c2都是指向常量池的，由于常量池的内容不能重复所以它们指向 的是同一个地方的同
         * 一个对象，但是new出来存放的字符串常量，则不是放在这个区域中，所以new String("123")
         * 是创建了两个对象。另外一点String常量池中的 对象是不会被JVM回收的，而堆中的对象则会被
         * 垃圾回收站回收
         */
        String c=new String("123");
        String c1="123";
        String c2="123";
        System.out.println(c1==c2);// true
        System.out.println(c==c1);// false
        System.out.println(c.hashCode()==c1.hashCode());// true
        System.out.println(c.equals(c1));// true

        /**
         * 针对下面的代码，来做个说明，其实d和d1是等同的，但是这个过程却是不同，虽然结果一样，那
         * 么过程如何不同呢？d是创建了三个字符串常量，然后将这些拼接起来，生成另一个字符串常量，
         * 这个过程生成了四个字符串对象。另外，顺带说下，String类型不是原始数据类型,它是一个不可
         * 变类，但由于它的机制决定了它的多重角色性。
         */
        String d = "1" + "2" + "3";
        String d1 = "123";
        String d2 = new String("1" + "2" + "3");
        String d3 = new String("1" + "2" + "3");
        System.out.println(d.equals(d1));// true
        System.out.println(d == d1);// true
        System.out.println(d.hashCode() == d1.hashCode());// true
        System.out.println(d2.hashCode() == d3.hashCode());// true
    }
}
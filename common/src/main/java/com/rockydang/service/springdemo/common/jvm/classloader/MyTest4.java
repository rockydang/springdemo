package com.rockydang.service.springdemo.common.jvm.classloader;

/**
 * 首次主动使用类的时候,会导致类的初始化;
 * 静态代码块也就会被执行;
 * <p>
 * <p>
 * 对于数组实例来说,其类型由JVM在运行期间动态生成的,标识为[Lcom.rockydang.service.springdemo.common.jvm.classloader.MyParent4
 * 这种形式,动态生成的类型,其父类型为Object
 * <p>
 * 对于数组来说,JavaDoc将构成数组的元素为Component,实际上为数组降低一个维度的类型;
 * <p>
 * 助记符:
 * anewarray : 表示创建一个引用类型的(如:类、接口、数组)数组,并将其值压入栈顶;
 * newarray  : 表示创建一个指定的原始类型(如:int、float、byte等)数组,并将其值压入栈顶;
 * <p>
 * <p>
 * Created by yanxiao on 2018/2/16.
 */
public class MyTest4 {
    public static void main(String[] args) {
     /*   MyParent4 myParent4 = new MyParent4();
        System.out.println("-------");
        MyParent4 myParent5 = new MyParent4();*/

        //数组对象不会生成对象的实例,也就是说没有生成对象的实例;

        //虚拟机在运行期生成的类型;
        // [Lcom.rockydang.service.springdemo.common.jvm.classloader.MyParent4;
        MyParent4[] myParentArray = new MyParent4[1];
        System.out.println(myParentArray.getClass());
        System.out.println(myParentArray.getClass().getSuperclass());

        int[] intArray = new int[1];
        System.out.println(intArray.getClass());//[I
        System.out.println(intArray.getClass().getSuperclass());

        short[] shortArray = new short[1];
        System.out.println(shortArray.getClass());//[S
        System.out.println(shortArray.getClass().getSuperclass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());//[B
        System.out.println(bytes.getClass().getSuperclass());

        float[] floats = new float[1];
        System.out.println(floats.getClass());//[F
        System.out.println(floats.getClass().getSuperclass());

        double[] doubles = new double[1];
        System.out.println(doubles.getClass());//[D
        System.out.println(doubles.getClass().getSuperclass());
    }
}

class MyParent4 {
    static {
        System.out.println("MyParent4 static code.");
    }
}
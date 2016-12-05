package com.rockydang.service.springdemo.common.asm;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;
import org.springframework.asm.Type;
import org.springframework.asm.commons.GeneratorAdapter;
import org.springframework.asm.commons.Method;

import  java.io.FileOutputStream;
import  java.io.PrintStream;

//import  org.objectweb.asm.ClassWriter;
//import  org.objectweb.asm.MethodVisitor;
//import  org.objectweb.asm.Opcodes;
//import  org.objectweb.asm.Type;
//import  org.objectweb.asm.commons.GeneratorAdapter;
//import  org.objectweb.asm.commons.Method;
/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年11月12日 22:27
 */
public class AsmTest extends  ClassLoader  implements Opcodes {

    public   static   void  main( final  String args[])  throws  Exception {

        // creates a ClassWriter for the Example public class,
        // which inherits from Object

//        ClassWriter cw = new  ClassWriter(0);
        ClassWriter cw = new  ClassWriter(true);
        cw.visit(V1_1, ACC_PUBLIC, "Example" ,  null ,  "java/lang/Object" ,  null );
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>" ,  "()V" ,  null ,
                null );
        mw.visitVarInsn(ALOAD, 0 );
        mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object" ,  "<init>" ,  "()V" );
        mw.visitInsn(RETURN);
        mw.visitMaxs(1 ,  1 );
        mw.visitEnd();
        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main" ,
                "([Ljava/lang/String;)V" ,  null ,  null );
        mw.visitFieldInsn(GETSTATIC, "java/lang/System" ,  "out" ,
                "Ljava/io/PrintStream;" );
        mw.visitLdcInsn("Hello world!" );
        mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream" ,  "println" ,
                "(Ljava/lang/String;)V" );
        mw.visitInsn(RETURN);
        mw.visitMaxs(2 ,  2 );
        mw.visitEnd();
        byte [] code = cw.toByteArray();
        FileOutputStream fos = new  FileOutputStream( "Example.class" );
        fos.write(code);
        fos.close();
        AsmTest loader = new  AsmTest();
        Class exampleClass = loader
                .defineClass("Example" , code,  0 , code.length);
        exampleClass.getMethods()[0 ].invoke( null ,  new  Object[] {  null  });

        // ------------------------------------------------------------------------
        // Same example with a GeneratorAdapter (more convenient but slower)
        // ------------------------------------------------------------------------

//        cw = new  ClassWriter(ClassWriter.COMPUTE_MAXS);
        cw = new  ClassWriter(true);
        cw.visit(V1_1, ACC_PUBLIC, "Example" ,  null ,  "java/lang/Object" ,  null );
        Method m = Method.getMethod("void <init> ()" );
        GeneratorAdapter mg = new  GeneratorAdapter(ACC_PUBLIC, m,  null ,  null ,
                cw);
        mg.loadThis();
        mg.invokeConstructor(Type.getType(Object.class), m);
        mg.returnValue();
        mg.endMethod();
        m = Method.getMethod("void main (String[])" );
        mg = new  GeneratorAdapter(ACC_PUBLIC + ACC_STATIC, m,  null ,  null , cw);
        mg.getStatic(Type.getType(System.class), "out", Type
                .getType(PrintStream.class));
        mg.push("Hello world!");
        mg.invokeVirtual(Type.getType(PrintStream.class), Method
                .getMethod("void println (String)"));
        mg.returnValue();
        mg.endMethod();
        cw.visitEnd();
        code = cw.toByteArray();
        loader = new AsmTest();
        exampleClass = loader.defineClass("Example" , code,  0 , code.length);
        exampleClass.getMethods()[0 ].invoke( null ,  new  Object[] {  null  });

    }
}
package com.rockydang.service.springdemo.common.annotation.example1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yanxiao on 16/4/24.
 */
public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        String className="com.rockydang.service.springdemo.common.annotation.example1";

        Class testClass = Class.forName(className);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed " + exc);
                } catch (Exception exc) {
                    System.out.println("INVALID @ExceptionTest3" + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}

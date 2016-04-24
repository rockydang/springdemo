package com.rockydang.service.springdemo.common.annotation.example2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yanxiao on 16/4/24.
 */
public class RunTests2 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        String className = "com.rockydang.service.springdemo.common.annotation.example2.Sample3";

        Class testClass = Class.forName(className);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();

                    Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("INVALID @ExceptionTest3" + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}

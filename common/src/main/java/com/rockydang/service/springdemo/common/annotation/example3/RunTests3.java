package com.rockydang.service.springdemo.common.annotation.example3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yanxiao on 16/4/24.
 */
public class RunTests3 {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        String className = "com.rockydang.service.springdemo.common.annotation.example3.Sample3";
        Class testClass = Class.forName(className);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest3.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest3.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed:  %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("INVALID @ExceptionTest3" + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}

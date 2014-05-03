package org.antran.java.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestRunner {

    public static void main(String[] args) {
        System.out.println("Running tests");

        int passed = 0, failed = 0, ignored = 0;

        Class<ASmallTest> obj = ASmallTest.class;
        if (obj.isAnnotationPresent(TestInfo.class)) {
            Annotation annotation = obj.getAnnotation(TestInfo.class);
            TestInfo testInfo = (TestInfo) annotation;

            System.out.println("Priority: " + testInfo.priority());
            System.out.println("Developer: " + testInfo.createdBy());
            System.out.println("Tags: " + Arrays.toString(testInfo.tags()));
        }

        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TestCase.class)) {
                Annotation annotation = method.getAnnotation(TestCase.class);
                TestCase testCase = (TestCase) annotation;

                if (testCase.enable()) {
                    try {
                        method.invoke(obj.newInstance());
                        passed++;
                    }
                    catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
                        e.printStackTrace();
                        failed++;
                    }
                }
                else {
                    ignored++;
                }
            }
        }
        
        System.out.println("Summary");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Ignored: " + ignored);
    }
}

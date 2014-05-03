package org.antran.java.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TestInfo {

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    Priority priority() default Priority.LOW;

    String[] tags() default "";

    String createdBy() default "An Tran";

    String lastModified() default "05/03/2014";
}

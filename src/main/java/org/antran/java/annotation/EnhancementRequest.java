package org.antran.java.annotation;

public @interface EnhancementRequest {

    long id();

    String synopsis();

    String engineer() default "unassigned";

    String date() default "unknown";
}

package com.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
@Documented
public @interface MyAnnotation  {
    String value() default "leon";
}

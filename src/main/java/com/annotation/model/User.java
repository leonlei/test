package com.annotation.model;

import com.annotation.MyAnnotation;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/26
 */
public class User {
    @MyAnnotation(value = "11")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

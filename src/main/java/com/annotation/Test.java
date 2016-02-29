package com.annotation;

import com.annotation.model.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/26
 */
public class Test {
    public static void main(String[] args) {
        User u = new User();
        //检测user类的属性是不是含有@MyAnnotation的注解
        Field[] fields = u.getClass().getDeclaredFields();
        for(Field field : fields){
          if(field.isAnnotationPresent(MyAnnotation.class)){
              MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
              System.out.println(field.getName() + ":" + annotation.value());
          }
        }
    }
}

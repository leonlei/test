package com.proxy.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/25
 */
public class BookProxy implements InvocationHandler{
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("事物开始");
        Object result= method.invoke(target,args);
        System.out.println("事物结束");
        return result;
    }

}

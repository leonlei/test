package com.singleton;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/25
 */
public class ErHanSingleton {

    private final static ErHanSingleton instance = new ErHanSingleton();

    private ErHanSingleton(){

    }

    public static ErHanSingleton getInstance(){
        return instance;
    }
}

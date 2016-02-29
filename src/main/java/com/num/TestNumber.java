package com.num;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/25
 */
public class TestNumber {
    public static void main(String[] args) {
        Integer i = 0;
        Integer.parseInt("1");
        int j = 1;
        Long m = Long.valueOf(1);

        String s = new String("123");

        Integer.valueOf(1);

    }


    public void test(){
        try {
            InputStream ins = new FileInputStream("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/29
 */
public class TestListGeneric {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        //list.add(0);
       // unsafeAdd(list,0);
        System.out.println(list.get(0));
    }

    static void unsafeAdd(List list,Object o){
        list.add(o);
    }
}

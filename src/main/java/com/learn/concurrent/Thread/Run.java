package com.learn.concurrent.Thread;

import com.learn.concurrent.Thread.MyThread;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/19
 */
public class Run {
    public static void main(String[] args){
        try{
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.print("守护线程");
        }catch (Exception e){

        }

    }
}

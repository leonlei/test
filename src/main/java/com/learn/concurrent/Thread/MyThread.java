package com.learn.concurrent.Thread;

/**
 *
 * Created by Administrator.
 * User: Leon
 * 2016/2/19
 */
public class MyThread extends Thread {
    private int i = 0;
    @Override
    public void run(){
        try{
            while (true){
                i++;
                System.out.print("i = "+i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

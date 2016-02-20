package com.learn.concurrent.Thread;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/19
 */
public class HasSelfPrivateNum {
    public void addI(String userName){
        int num = 0;

        if("a".equals(userName)){
            num = 100;
            System.out.print("a set over");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            num = 200;
            System.out.print("b set over");
        }
    }
}

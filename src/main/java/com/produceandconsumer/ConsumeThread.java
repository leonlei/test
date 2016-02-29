package com.produceandconsumer;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/24
 */
public class ConsumeThread implements Runnable {

    private Public resoure;

    ConsumeThread(Public resoure){
        this.resoure = resoure;
    }
    public void run() {
        for(int i = 0; i < 10; i++){
            resoure.decreate();
            try{
                Thread.sleep((int)(Math.random()*500));
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

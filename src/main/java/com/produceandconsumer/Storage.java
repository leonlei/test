package com.produceandconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/24
 */
public class Storage implements Public{

    private int maxSize = 10;
    private LinkedBlockingQueue list = new LinkedBlockingQueue(10);

    public void increate() {
        if(list.size() == maxSize){
            System.out.println(Thread.currentThread().getName()+"不能生产,库存为"+list.size());
        }
        for(int i = 0; i < 10; i++){
            try {
                list.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"生产一个,库存为:"+list.size());
        }
    }
    public void decreate() {
        if(list.size() == 0){
            System.out.println(Thread.currentThread().getName()+"不能消费,库存为"+list.size());
        }
        for(int i = 0; i < 10; i++){
            try {
                list.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"消费一个,库存为:"+list.size());
        }
    }
}

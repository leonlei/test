package com.produceandconsumer;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/24
 */
public class PublicResoure implements Public{

    private int length = 10;
    private int num = 0;

    public synchronized void increate(){
        while(num >= 10){
            System.out.println("不能生产，库存已满");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        num++;
        System.out.println(Thread.currentThread().getName()+"生产一个，当前库存为"+num);
    }

    public synchronized void decreate(){
        while(num <= 0){
            System.out.println("不能消费，库存已空");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        num--;
        System.out.println(Thread.currentThread().getName()+"消费一个，当前库存为"+num);
    }



















}

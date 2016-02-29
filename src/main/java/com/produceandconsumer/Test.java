package com.produceandconsumer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator.
 * User: Leon
 * 2016/2/24
 */
public class Test {
    public static void main(String[] args) {
        Public resoure = new Storage();
        Thread thread1 = new Thread(new ProduceThread(resoure));
        Thread thread2 = new Thread(new ConsumeThread(resoure));
        Thread thread3 = new Thread(new ProduceThread(resoure));
        Thread thread4 = new Thread(new ConsumeThread(resoure));

//        thread1.start();;
//        thread2.start();
//        thread3.start();
//        thread4.start();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(thread1);
        pool.execute(thread2);
        pool.execute(thread3);
        pool.execute(thread4);
        String s = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
        System.out.println(s);


        try {
            InputStream ins = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

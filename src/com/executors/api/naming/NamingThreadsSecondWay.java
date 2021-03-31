package com.executors.api.naming;

import com.executors.api.common.LoopTaskC;

public class NamingThreadsSecondWay {

    public static void main(String[] a) throws InterruptedException {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");
        new Thread(new LoopTaskC(),"MyThread-1").start();
        Thread t = new Thread(new LoopTaskC());
        //t.setName("MyThread-2");
        t.start();
        Thread.sleep(800);
        t.setName("MyThread-2");
        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

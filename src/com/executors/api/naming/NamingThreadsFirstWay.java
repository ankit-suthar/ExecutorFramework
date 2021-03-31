package com.executors.api.naming;

import com.executors.api.common.LoopTaskB;

public class NamingThreadsFirstWay {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");
        new Thread(new LoopTaskB()).start();
        Thread t = new Thread(new LoopTaskB());
        t.start();
        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

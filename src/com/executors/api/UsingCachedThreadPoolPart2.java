package com.executors.api;

import com.executors.api.common.LoopTaskC;
import com.executors.api.common.NamedThreadsFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPoolPart2 {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        executorService.execute(new LoopTaskC());   //Task-1
        executorService.execute(new LoopTaskC());   //Task-2
        executorService.execute(new LoopTaskC());   //Task-3
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.execute(new LoopTaskC());   //Task-4
        executorService.execute(new LoopTaskC());   //Task-5
        executorService.execute(new LoopTaskC());   //Task-6
        executorService.execute(new LoopTaskC());   //Task-7
        executorService.execute(new LoopTaskC());   //Task-8

        executorService.shutdown();
        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

package com.executors.api;

import com.executors.api.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {

    public static void main(String[] a){
        System.out.println("Main starts");
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.execute(new LoopTaskA());
        executorService.shutdown();
        System.out.println("Main ends");
    }
}

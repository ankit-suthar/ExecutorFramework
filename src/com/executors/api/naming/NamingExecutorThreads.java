package com.executors.api.naming;

import com.executors.api.common.LoopTaskC;
import com.executors.api.common.NamedThreadsFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NamingExecutorThreads {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");
        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        executorService.execute(new LoopTaskC());
        System.out.println("["+ currentThreadName +"] Main Ends");
        executorService.shutdown();
    }
}

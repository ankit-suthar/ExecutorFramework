package com.executors.api.returnvalues;

import com.executors.api.common.CalculationTaskA;
import com.executors.api.common.LoopTaskA;
import com.executors.api.common.NamedThreadsFactory;
import com.executors.api.common.ValueReturningTaskA;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReturningValuesUsingExecutorsFirstWay {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());
        Future<Integer> result1 = executorService.submit(new CalculationTaskA(2,3,2000));
        Future<Integer> result2 = executorService.submit(new CalculationTaskA(3,4,1000));
        Future<Integer> result3 = executorService.submit(new CalculationTaskA(4,5,500));

        Future<?> result4 = executorService.submit(new LoopTaskA());
        Future<Double> result5 = executorService.submit(new LoopTaskA(),999.888);
        executorService.shutdown();

        try {
            System.out.println("Result-1 = "+ result1.get());
            System.out.println("Result-2 = "+ result2.get());
            System.out.println("Result-3 = "+ result3.get());
            System.out.println("Result-4 = "+ result4.get());
            System.out.println("Result-5 = "+ result5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

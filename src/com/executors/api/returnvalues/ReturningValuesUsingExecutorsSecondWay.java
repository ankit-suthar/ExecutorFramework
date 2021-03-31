package com.executors.api.returnvalues;

import com.executors.api.common.CalculationTaskB;
import com.executors.api.common.LoopTaskA;
import com.executors.api.common.NamedThreadsFactory;
import com.executors.api.common.TaskResult;

import java.util.concurrent.*;

public class ReturningValuesUsingExecutorsSecondWay {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadsFactory());

        CompletionService<TaskResult<String,Integer>> completionService = new ExecutorCompletionService<TaskResult<String,Integer>>(executorService);

        completionService.submit(new CalculationTaskB(2,3,2000));
        completionService.submit(new CalculationTaskB(3,4,1000));
        completionService.submit(new CalculationTaskB(4,5,500));

//        Future<?> result4 = executorService.submit(new LoopTaskA());
        completionService.submit(new LoopTaskA(),new TaskResult<String,Integer>("LoopTaskA-1",999));
        executorService.shutdown();

        for(int i=0;i<4;i++){
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

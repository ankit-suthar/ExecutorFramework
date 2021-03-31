package com.executors.api.common;

import java.util.concurrent.Callable;

public class CalculationTaskB implements Callable<TaskResult<String,Integer>> {

    private int a;
    private int b;
    private long sleepTime;
    private static int count=0;
    private int instanceNumber;
    private String taskId;

    public CalculationTaskB(int a, int b, long sleepTime){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "CalcTaskA-" + instanceNumber;
    }

    @Override
    public TaskResult<String,Integer> call() throws Exception {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### ["+ currentThreadName + "] <" + taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <"+ taskId + "> Sleeping for "+ sleepTime + " millis");

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("****** ["+ currentThreadName + "] <"+ taskId + "> DONE ******");
        return new TaskResult<String,Integer>(taskId,a+b);
    }


}

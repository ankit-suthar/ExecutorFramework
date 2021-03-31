package com.executors.api.common;

public class ValueReturningTaskB implements Runnable {

    private int a;
    private int b;
    private long sleepTime;
    private int sum;
    private static int count=0;
    private int instanceNumber;
    private String taskId;
    private ResultListener<Integer> resultListener;

    public ValueReturningTaskB(int a, int b, long sleepTime, ResultListener<Integer> resultListener){
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
        this.instanceNumber = ++count;
        this.taskId = "ValRuturnTaskB-" + instanceNumber;
        this.resultListener=resultListener;
    }

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### ["+ currentThreadName + "] <" + taskId + "> STARTING #####");
        System.out.println("[" + currentThreadName + "] <"+ taskId + "> Sleeping for "+ sleepTime + " millis");

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sum = a+b;

        System.out.println("****** ["+ currentThreadName + "] <"+ taskId + "> DONE ******");
        resultListener.notifyResult(sum);
    }

}

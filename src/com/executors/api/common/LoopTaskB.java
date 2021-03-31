package com.executors.api.common;

public class LoopTaskB implements Runnable {

    private static int count=0;
    private int instanceNumber;
    private String taskId;

    @Override
    public void run() {
        Thread.currentThread().setName("Amazing-Thread-"+instanceNumber);
        String currentThreadName = Thread.currentThread().getName();

        System.out.println("##### ["+currentThreadName+"] <"+ taskId +"> STARTING #####");
        for(int i=1;i<=10;i++){
            System.out.println("["+currentThreadName+"] <"+ taskId +">"+" Tick Tick "+i);

            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("***** ["+currentThreadName+"] <"+ taskId +"> DONE *****");
    }

    public LoopTaskB(){
        this.instanceNumber =++count;
        this.taskId="LoopTaskB"+ instanceNumber;
    }
}

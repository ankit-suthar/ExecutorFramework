package com.executors.api.common;

public class LoopTaskC implements Runnable {

    private static int count=0;
    private int instanceNumber;
    private String taskId;

    @Override
    public void run() {
//        String currentThreadName = Thread.currentThread().getName();

//        System.out.println("##### ["+currentThreadName+"] <"+ taskId +"> STARTING #####");
        System.out.println("##### ["+Thread.currentThread().getName()+"] <"+ taskId +"> STARTING #####");
        for(int i=1;i<=10;i++){
//            System.out.println("["+currentThreadName+"] <"+ taskId +">"+" Tick Tick "+i);
            System.out.println("["+Thread.currentThread().getName()+"] <"+ taskId +">"+" Tick Tick "+i);

            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("***** ["+currentThreadName+"] <"+ taskId +"> DONE *****");
        System.out.println("***** ["+Thread.currentThread().getName()+"] <"+ taskId +"> DONE *****");
    }

    public LoopTaskC(){
        this.instanceNumber =++count;
        this.taskId="LoopTaskC"+ instanceNumber;
    }
}

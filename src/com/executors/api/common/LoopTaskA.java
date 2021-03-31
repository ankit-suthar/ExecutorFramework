package com.executors.api.common;

public class LoopTaskA implements Runnable {

    private static int count=0;
    private int id;

    @Override
    public void run() {
        System.out.println("##### <TASK-"+id+"> STARTING #####");
        for(int i=1;i<=10;i++){
            System.out.println("<TASK-"+id+">"+" Tick Tick "+i);

            try {
                Thread.sleep((long) (Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("***** <TASK-"+id+"> DONE *****");
    }

    public LoopTaskA(){
        this.id=++count;
    }
}

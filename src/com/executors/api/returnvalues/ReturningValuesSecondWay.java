package com.executors.api.returnvalues;

import com.executors.api.common.ValueReturningTaskB;

public class ReturningValuesSecondWay {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");

        ValueReturningTaskB valueReturningTaskA1 = new ValueReturningTaskB(2,3,2000, new SumObserver("task-1"));
        Thread thread1 = new Thread(valueReturningTaskA1,"Thread-1");

        ValueReturningTaskB valueReturningTaskA2 = new ValueReturningTaskB(3, 4,1000,new SumObserver("task-2"));
        Thread thread2 = new Thread(valueReturningTaskA2,"Thread-2");

        ValueReturningTaskB valueReturningTaskA3 = new ValueReturningTaskB(4,5,500,new SumObserver("task-3"));
        Thread thread3 = new Thread(valueReturningTaskA3,"Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

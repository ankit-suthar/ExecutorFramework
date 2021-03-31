package com.executors.api.returnvalues;

import com.executors.api.common.ValueReturningTaskA;

public class ReturningValuesFirstWay {

    public static void main(String[] a){
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("["+ currentThreadName +"] Main Starts");

        ValueReturningTaskA valueReturningTaskA1 = new ValueReturningTaskA(2,3,2000);
        Thread thread1 = new Thread(valueReturningTaskA1,"Thread-1");

        ValueReturningTaskA valueReturningTaskA2 = new ValueReturningTaskA(3, 4,1000);
        Thread thread2 = new Thread(valueReturningTaskA2,"Thread-2");

        ValueReturningTaskA valueReturningTaskA3 = new ValueReturningTaskA(4,5,500);
        Thread thread3 = new Thread(valueReturningTaskA3,"Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Result-1 = "+valueReturningTaskA1.getSum());
        System.out.println("Result-2 = "+valueReturningTaskA2.getSum());
        System.out.println("Result-3 = "+valueReturningTaskA3.getSum());

        System.out.println("["+ currentThreadName +"] Main Ends");
    }
}

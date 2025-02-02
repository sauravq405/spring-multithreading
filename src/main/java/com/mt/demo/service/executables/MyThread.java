package com.mt.demo.service.executables;

import java.util.stream.IntStream;

public class MyThread extends Thread {
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        IntStream.rangeClosed(1, 5).mapToObj(i -> i+"-> "+Thread.currentThread().getName()+" with priority = "
                        +Thread.currentThread().getPriority())
                .forEach(System.out::println);
    }
}

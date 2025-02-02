package com.mt.demo.service.executables;

import java.util.stream.IntStream;

public class ThreadYielder extends Thread{
    @Override
    public void run() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            System.out.println(i + " - " + Thread.currentThread().getName());
            Thread.yield();
        });
    }
}

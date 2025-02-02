package com.mt.demo.service.executables;

import com.mt.demo.model.Counter;

import java.util.stream.IntStream;

public class ThreadCounter extends Thread{
    private Counter counter;
    public ThreadCounter(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        IntStream.rangeClosed(1, 1000).forEach(i -> counter.increment());
    }
}

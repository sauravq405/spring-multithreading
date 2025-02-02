package com.mt.demo.service.executables;

import java.util.stream.IntStream;

public class RunnableDemoExecutable implements Runnable{
    @Override
    public void run() {
        IntStream.rangeClosed(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName()));
    }
}

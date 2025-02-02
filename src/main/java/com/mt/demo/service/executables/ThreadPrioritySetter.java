package com.mt.demo.service.executables;

import java.util.stream.IntStream;

public class ThreadPrioritySetter extends Thread{
    public ThreadPrioritySetter(String name){
        super(name);
    }
    @Override
    public void run() {
        IntStream.rangeClosed(1, 5)
                .mapToObj(i -> {
                    StringBuilder result = new StringBuilder();
                    IntStream.rangeClosed(1, i).forEach(j ->
                            result.append(j).append("-> ").append(Thread.currentThread().getName())
                                    .append(" with priority = ").append(Thread.currentThread().getPriority())
                                    .append("\n")
                    );
                    return result.toString();
                })
                .forEach(System.out::print);
    }
}

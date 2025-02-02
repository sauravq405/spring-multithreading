package com.mt.demo.service.executables;

public class ThraedInterrupter extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ThraedInterrupter thread is running...");
    }
}

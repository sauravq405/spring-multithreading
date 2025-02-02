package com.mt.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadLifecycleDemo extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"- state of t1= RUNNING");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public ResponseEntity<Void> demoThreadLifecycle() throws InterruptedException {
        ThreadLifecycleDemo t = new ThreadLifecycleDemo();
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t.getState());
        t.start();
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t.getState());
        Thread.currentThread().sleep(1000);
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t.getState());
        t.join();
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t.getState());
        return ResponseEntity.noContent().build();
    }
}

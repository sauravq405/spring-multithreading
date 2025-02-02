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
        ThreadLifecycleDemo t1 = new ThreadLifecycleDemo();
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t1.getState());
        t1.start();
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t1.getState());
        Thread.currentThread().sleep(1000); // sleep()  -> current executing thread will
        // pause itself and give chance to t1 thread to execute itself.
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t1.getState());
        t1.join(); //join() -> current executing will pause itself and wait for t1 to completely
        // finish its' execution and then the control will be given back to current executing thread.
        System.out.println(Thread.currentThread().getName()+"- state of t1= "+t1.getState());
        return ResponseEntity.noContent().build();
    }
}

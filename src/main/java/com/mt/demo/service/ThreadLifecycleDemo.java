package com.mt.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class that extends Thread to demonstrate the lifecycle states of threads in Java.
 * This class provides a practical example of how a thread transitions through different states
 * like NEW, RUNNABLE, RUNNING, TIMED_WAITING, and TERMINATED during its execution.
 *
 *  @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
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


    /**
     * Demonstrates the lifecycle states of a thread in Java.
     * <ul>
     *   <li>ThreadLifecycleDemo t1 = new ThreadLifecycleDemo(); </li>
     *   <li>System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState()); --1. <b>NEW</b></li>
     *   <li>t1.start(); </li>
     *   <li>System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState()); --2. <b>RUNNABLE</b></li>
     *   <li>Thread.currentThread().sleep(1000); // sleep() -> current executing thread will pause itself and give chance to t1 thread to execute itself. From run() --3. <b>RUNNING</b></li>
     *   <li>System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState()); --4. <b>TIMED_WAITING</b></li>
     *   <li>t1.join(); // join() -> current executing will pause itself and wait for t1 to completely finish its' execution and then the control will be given back to current executing thread.</li>
     *   <li>System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState()); --5. <b>TERMINATED</b></li>
     * </ul>
     *
     * @return A ResponseEntity with no content, indicating the thread lifecycle demonstration has been performed.
     * @throws InterruptedException if any thread has interrupted the current thread.
     */
    public ResponseEntity<Void> demoThreadLifecycle() throws InterruptedException {
        ThreadLifecycleDemo t1 = new ThreadLifecycleDemo();
        System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState());
        t1.start();
        System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState());
        Thread.currentThread().sleep(1000);
        System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState());
        t1.join();
        System.out.println(Thread.currentThread().getName() + "- state of t1= " + t1.getState());
        return ResponseEntity.noContent().build();
    }
}

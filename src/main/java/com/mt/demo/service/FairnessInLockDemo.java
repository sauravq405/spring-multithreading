package com.mt.demo.service;

import com.mt.demo.model.UnfairLock;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FairnessInLockDemo {

    public ResponseEntity<Void> demoFairnessInLock() {
        UnfairLock unfairLock = new UnfairLock();
        Thread t1 = new Thread(() -> unfairLock.work());
        Thread t2 = new Thread(() -> unfairLock.work());
        Thread t3 = new Thread(() -> unfairLock.work());
        try {
            t1.start();
            Thread.sleep(50);
            t2.start();
            Thread.sleep(50);
            t3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Fairness means to mandate the order in which resources can be accessed by the threads,
        //threads should not access the resources in arbitrary manner
        //accessing the resource here = calling the run() method given in lambda () -> unfairLock.work()
        //Declaration of Reentrant should be like: Lock lock = new ReentrantLock(true);
        //UnfairLock being made fair by adding boolean value true in the constructor
        //If you want to make threads access the resource in the order of your declaration, then add a sleep of 50 milisecond
        //after each start() method  as below:
        /*try {
            t1.start();
            Thread.sleep(50);
            t2.start();
            Thread.sleep(50);
            t3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //Order followed here is FIFO
        //And there is no thread starvation. All the threads get a chance to execute.
        return ResponseEntity.noContent().build();
    }
}

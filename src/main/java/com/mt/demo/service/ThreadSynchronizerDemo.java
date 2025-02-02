package com.mt.demo.service;

import com.mt.demo.model.Counter;
import com.mt.demo.service.executables.ThreadCounter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadSynchronizerDemo {
    public ResponseEntity<Void> demoSynchronization() {
        Counter counter = new Counter();
        ThreadCounter t1= new ThreadCounter(counter);
        ThreadCounter t2= new ThreadCounter(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Value of count = "+counter.getCount());
        //We have made the method increment() inside Counter class as synchronized
        //When multiple threads are acting on a shared resource
        //there might be chances that one thread interferes the action of other
        //leading to loss of data or accuracy in end goal
        //TO ENSURE ONLY THREAD ACTS AT A RESOURCE AT ONE POINT OF TIME
        //Java provides SYNCHRONIZED keyword to achieve this.
        return ResponseEntity.noContent().build();
    }
}

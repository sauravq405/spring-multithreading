package com.mt.demo.service;

import com.mt.demo.service.executables.ThreadYielder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadYieldDemo {
    public ResponseEntity<Void> demoThreadYield() {
        ThreadYielder t1 = new ThreadYielder();
        ThreadYielder t2 = new ThreadYielder();
        t1.start();
        t2.start();
        // Here Thread.yield() method has been called inside run() method of ThreadYielder
        // yield() method
        return ResponseEntity.noContent().build();
    }
}

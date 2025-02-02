package com.mt.demo.service;

import com.mt.demo.service.executables.MyThread;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadMethodsDemo {
    public ResponseEntity<Void> demoThreadMethods() throws InterruptedException {
        MyThread t1 = new MyThread("MyThread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t1.join();
        return ResponseEntity.noContent().build();
    }
}

package com.mt.demo.service;

import com.mt.demo.model.ReadWriteCounter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class ReadWriteLockDemo {
    public ResponseEntity<Void> demoReadWriteLock() {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Runnable readTask = () -> {
            IntStream.rangeClosed(1,10).forEach(i -> {
                System.out.println(Thread.currentThread().getName()+" read: "+readWriteCounter.getCount());
            });
        };
        Runnable writeTask = () -> {
            IntStream.rangeClosed(1,10).forEach(i -> {
                readWriteCounter.increment();
                System.out.println(Thread.currentThread().getName()+" incremented.");
            });
        };
        Thread t1 = new Thread(writeTask);
        Thread t2 = new Thread(readTask);
        Thread t3 = new Thread(readTask);

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final count: "+readWriteCounter.getCount());
        // Read-write locks in Java are used to avoid unnecessary blocking of threads.
       // If any thread is trying to acquire the read lock and no write lock is currently held by another thread,
       // then the read lock will be granted to that thread.
        return ResponseEntity.noContent().build();
    }
}

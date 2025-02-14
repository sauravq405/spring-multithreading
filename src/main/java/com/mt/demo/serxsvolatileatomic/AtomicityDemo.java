package com.mt.demo.serxsvolatileatomic;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Service
public class AtomicityDemo {
    public ResponseEntity<Void> demoAtomicity() throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            IntStream.rangeClosed(1,1000).forEach(i -> counter.increment());
        });
        Thread t2 = new Thread(() -> {
            IntStream.rangeClosed(1,1000).forEach(i -> counter.increment());
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: "+counter.read());
        return ResponseEntity.noContent().build();
    }
}

class Counter {

    //Apart from locks and synchronized keywords, Java provides Atomic classes
    // which can ensure thread saftey.
    //When we use Atomic classes, multiple threads can not create race condition on the fields
    // i.e. at one time, only one particular thread will act.
    private AtomicInteger count = new AtomicInteger(0);
    public void increment(){
        count.incrementAndGet();
    }
    public int read(){
       return count.get();
    }
}

package com.mt.demo.serxsvolatileatomic;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VolatileDemo {
    public ResponseEntity<Void> demoVolatileDemo() {
        SharedResource sharedResource = new SharedResource();
        Thread readerThread = new Thread(() -> sharedResource.read());
        Thread writerThread = new Thread(() ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedResource.update();
        });
        readerThread.start();
        writerThread.start();
        return ResponseEntity.noContent().build();
    }
}

class SharedResource {
    //Every variable that a thread encounters, it keeps a local copy of the variable in it's cache
    //which may lead to inaccurate read output in a multithreaded environment
    //to overcome this we have volatile keyword
    //by marking a field with volatile keyword,
    // we are essentially telling java to keep the value in RAM/ main memory
    //instead of the cache of the thread

    private volatile boolean status = false;
    public void update(){
        status = true;
        System.out.println("Status updated to: "+status);
    }

    public void read(){
        while(!status){
           //do-nothing
        }
        System.out.println("Current status: "+status);
    }
}

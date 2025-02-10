package com.mt.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

class SharedResource{
    int data;
    boolean hasData;
    public synchronized void produce(int value){
        while(hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced: "+data);
        notify();
    }
    public synchronized int consume(){
        while(!hasData){
            try{
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+data);
        notify();
        return data;
    }
}

class Producer implements Runnable{
    SharedResource sharedResource;

    Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }
    @Override
    public void run() {
        IntStream.rangeClosed(1, 10).forEach(i -> sharedResource.produce(i));
    }
}

class Consumer implements Runnable{

    SharedResource sharedResource;

    Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10).forEach(i -> sharedResource.consume());
    }
}
@Service
public class ProducerConsumerDemo {

    public ResponseEntity<Void> demoProducerConsumer() {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(new Producer(sharedResource));
        Thread t2 = new Thread(new Consumer(sharedResource));
        t1.start();
        t2.start();
        return ResponseEntity.noContent().build();
    }
}

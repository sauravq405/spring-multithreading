package com.mt.demo.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock {
    Lock lock = new ReentrantLock(true);
    //UnfairLock being made fair by adding boolean value true in the constructor
    public void work(){
        try {
           lock.lock();
           System.out.println(Thread.currentThread().getName()+" acquired lock.");
           Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(Thread.currentThread().getName()+" interrupted.");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName()+" released lock.");
            lock.unlock(); //Sysop should be above lock.unlock(), to maintain consistency
        }
    }
}

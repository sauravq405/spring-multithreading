package com.mt.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class RentrantExample {
    Lock lock = new ReentrantLock();
    private void outerMethod(){
        lock.lock();
        try{
            System.out.println("Called outerMethod");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    private void innerMethod(){
        lock.lock();
        try{
            System.out.println("Called innerMethod");
        }finally {
            lock.unlock();
        }
    }

    public ResponseEntity<Void> runReantrant(){
        outerMethod();
        /*Ideally this situation should have resulted in DEADLOCK
        the thread has acquired the lock in outerMethod(), and is waiting for itself to release it
        before acquiring the lock again in innerMethod().
        Now this is where the class ReentrantLock comes into picture, the implementation is intelligent enough
        to understand that if SAME THREAD had acquired the lock before, it can acquire the lock again
        without WAITING.
        Internally, it maintains a count to check how many times the lock has been acquired.
        Ecah lock call must be paired with an unlock call. that's how consistency is maintained.
        But if
        finally {
            lock.unlock();
            lock.unlock();
        }
        In the above case, it might lead to consistency.
        Ideally, if you try to unlock a an already unlocked lock, it should throw an exception.
        Using ReentrantLock you can also simulate the behaviour of synchronized keyword
        * */
        return ResponseEntity.noContent().build();
    }
}

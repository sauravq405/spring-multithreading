package com.mt.demo.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    private int count = 0;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            count++;
           Thread.sleep(50);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }
}

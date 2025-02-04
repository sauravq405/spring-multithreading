package com.mt.demo.model;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "-- attempting withdrawl " + amount);
        try {
            if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                if (amount <= balance) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-- proceeding withdrawl " + amount);
                        Thread.sleep(5000);
                        balance = balance - amount; //alternatively: balance -= amount;
                        System.out.println(Thread.currentThread().getName() + "-- completed withdrawl. Remaining balance: " + balance);
                    } catch (InterruptedException e) {
                        log.warn("Interrupted thread", e);
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }

                } else {
                    System.out.println(Thread.currentThread().getName() + "-- insufficient funds");
                }

            } else {
                System.out.println(Thread.currentThread().getName() + "-- couldn't acquire lock.");
            }

        } catch (Exception e) {
            log.warn("Interrupted thread", e);
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            //clean-up code
        }

    }

    public synchronized void withdrawSynchronized(int amount) {
        System.out.println(Thread.currentThread().getName() + "-- attempting withdrawl " + amount);
        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + "-- proceeding withdrawl " + amount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }
            balance = balance - amount; //alternatively: balance -= amount;
            System.out.println(Thread.currentThread().getName() + "-- completed withdrawl. Remaining balance: " + balance);

        } else {
            System.out.println(Thread.currentThread().getName() + "-- insufficient funds");
        }
    }
}

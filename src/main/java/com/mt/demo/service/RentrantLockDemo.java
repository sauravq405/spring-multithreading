package com.mt.demo.service;

import com.mt.demo.model.BankAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RentrantLockDemo {
    public ResponseEntity<Void> demoRentrantLock() {
        BankAccount sbi = new BankAccount();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(runnable, "thread1");
        Thread t2 = new Thread(runnable, "thread2");
        t1.start();
        t2.start();
        return ResponseEntity.noContent().build();
    }
}

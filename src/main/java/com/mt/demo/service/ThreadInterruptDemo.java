package com.mt.demo.service;

import com.mt.demo.service.executables.ThraedInterrupter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadInterruptDemo {

    public ResponseEntity<Void> demoThreadInterrupt() {
        ThraedInterrupter thraedInterrupter = new ThraedInterrupter();
        thraedInterrupter.start();
        thraedInterrupter.interrupt(); // interrupt() method basically changes the current state of a thread,
        // which means if a thread is sleeping, disturb the sleep
        //if a thread is executing, pause the execution
        // if a thread is waiting, bring it out of wait state
        return ResponseEntity.noContent().build();
    }
}

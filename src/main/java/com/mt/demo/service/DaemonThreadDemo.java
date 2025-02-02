package com.mt.demo.service;

import com.mt.demo.service.executables.DaemonThreadSetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DaemonThreadDemo {

    public ResponseEntity<Void> demoDaemonThread() {
        DaemonThreadSetter t = new DaemonThreadSetter();
        t.setDaemon(true);
        t.start();
        System.out.println("Reached end of method: demoDaemonThread()");
        return ResponseEntity.noContent().build();
    }
}

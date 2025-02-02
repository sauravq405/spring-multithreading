package com.mt.demo.service;

import com.mt.demo.service.executables.DaemonThreadSetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DaemonThreadDemo {

    public ResponseEntity<Void> demoDaemonThread() {
        DaemonThreadSetter t = new DaemonThreadSetter();
        t.setDaemon(true);
        //Daemon Threads are background threads
        //Garbage collector is an example
        //JVM doesn't wait for daemon threads before shutting down
        //But JVM does wait for user threads
        //in this case
        t.start();
        System.out.println("Reached end of method: demoDaemonThread()");
        return ResponseEntity.noContent().build();
    }
}

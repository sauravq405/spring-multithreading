package com.mt.demo.service;

import com.mt.demo.service.executables.ThreadPrioritySetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThreadPriorityDemo {

    public ResponseEntity<Void> demoThreadPriority() {
        ThreadPrioritySetter l= new ThreadPrioritySetter("LOW PRIORITY THREAD");
        ThreadPrioritySetter m= new ThreadPrioritySetter("MEDIUM PRIORITY THREAD");
        ThreadPrioritySetter h= new ThreadPrioritySetter("HIGH PRIORITY THREAD");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
        return ResponseEntity.noContent().build();
    }
}

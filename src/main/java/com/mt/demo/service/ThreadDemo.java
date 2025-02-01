package com.mt.demo.service;

import com.mt.demo.service.executables.RunnableDemoExecutable;
import com.mt.demo.service.executables.ThreadDemoExecutable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class ThreadDemo {

    public ResponseEntity<?> printThreadNames() {
        ThreadDemoExecutable threadDemoExecutable = new ThreadDemoExecutable();
        threadDemoExecutable.start();
        IntStream.rangeClosed(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName()));
        return ResponseEntity.ok(Math.random());
    }

    public ResponseEntity<Void> printRunnableNames() {
        RunnableDemoExecutable runnableDemoExecutable = new RunnableDemoExecutable();
        Thread thread = new Thread(runnableDemoExecutable);
        thread.start();
        IntStream.rangeClosed(1,1000).forEach(i -> System.out.println(Thread.currentThread().getName()));
        return ResponseEntity.noContent().build();
    }
}

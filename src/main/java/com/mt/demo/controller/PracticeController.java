package com.mt.demo.controller;

import com.mt.demo.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private ThreadDemo threadDemo;
    @Autowired
    private ThreadLifecycleDemo threadLifecycleDemo;
    @Autowired
    private ThreadMethodsDemo threadMethodsDemo;
    @Autowired
    private ThreadPriorityDemo threadPriorityDemo;
    @Autowired
    private ThreadInterruptDemo threadInterruptDemo;
    @Autowired
    private ThreadYieldDemo threadYieldDemo;

    @GetMapping("/practice")
    public ResponseEntity<?> practice() {
           return practiceService.practice();
    }

    @GetMapping("/printThreadNames")
    public ResponseEntity<?> printThreadNames() {
        return threadDemo.printThreadNames();
    }

    @GetMapping("/printRunnableNames")
    public ResponseEntity<Void> printRunnableNames() {
        return threadDemo.printRunnableNames();
    }

    @GetMapping("/threadLifecycleDemo")
    public ResponseEntity<Void> demoThreadLifecycle() throws InterruptedException {
        return threadLifecycleDemo.demoThreadLifecycle();
    }

    @GetMapping("/threadMethodsDemo")
    public ResponseEntity<Void> demoThreadMethods() throws InterruptedException {
        return threadMethodsDemo.demoThreadMethods();
    }

    @GetMapping("/threadPriorityDemo")
    public ResponseEntity<Void> demoThreadPriority() throws InterruptedException {
        return threadPriorityDemo.demoThreadPriority();
    }

    @GetMapping("/threadInterruptDemo")
    public ResponseEntity<Void> demoThreadInterrupt() throws InterruptedException {
        return threadInterruptDemo.demoThreadInterrupt();
    }

    @GetMapping("/threadYieldDemo")
    public ResponseEntity<Void> demoThreadYield() throws InterruptedException {
        return threadYieldDemo.demoThreadYield();
    }
}

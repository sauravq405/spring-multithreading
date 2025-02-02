package com.mt.demo.controller;

import com.mt.demo.service.PracticeService;
import com.mt.demo.service.ThreadDemo;
import com.mt.demo.service.ThreadLifecycleDemo;
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

    @GetMapping("/demoThreadLifecycle")
    public ResponseEntity<Void> demoThreadLifecycle() throws InterruptedException {
        return threadLifecycleDemo.demoThreadLifecycle();
    }
}

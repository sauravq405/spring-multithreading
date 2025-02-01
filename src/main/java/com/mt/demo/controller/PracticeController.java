package com.mt.demo.controller;

import com.mt.demo.service.PracticeService;
import com.mt.demo.service.ThreadDemo;
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

    @GetMapping("/practice")
    public ResponseEntity<?> practice() {
           return practiceService.practice();
    }

    @GetMapping("/printThreadNames")
    public ResponseEntity<?> printThreadNames() {
        return threadDemo.printThreadNames();
    }

    @GetMapping("/printRunnableNames")
    public ResponseEntity<?> printRunnableNames() {
        return threadDemo.printRunnableNames();
    }
}

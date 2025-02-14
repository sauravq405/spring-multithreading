package com.mt.demo.serxscheduledexecutors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduledExecutorDemo {


    public ResponseEntity<Void> demoScheduledExecutor() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //It executes AFTER the time delay specified
        int timeout = 5;
        scheduler.schedule(() -> {
            System.out.println("Task completed after "+timeout+" secs");

        }, timeout, TimeUnit.SECONDS);
        scheduler.shutdown();
        demoScheduledExecutorScheduleRate();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> demoScheduledExecutorScheduleRate() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //It executes AFTER the initial time delay specified in a period
        int timeout = 5;
        int bufferTime = 20;
        scheduler.scheduleAtFixedRate(() -> System.out.println("Task running after every "+timeout+" secs"),
                timeout, timeout, TimeUnit.SECONDS);
        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown");
            scheduler.shutdown();
        }, bufferTime, TimeUnit.SECONDS);

        //If we directly call the method shutdown() after scheduleAtFixedRate(),
        // then the  scheduleAtFixedRate() will not get a chance to execute, unlike shedule() where task is created in a queue and waited for it's termination
        // here it is handled by a period, so we need to call shutdown inside shedule() method giving long enough time delay
        //scheduler.shutdown();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> demoScheduledExecutorScheduleDelay() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //It executes AFTER the initial time delay specified but wait for the delay time
        int timeout = 5;
        int bufferTime = 20;
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task running after every "+timeout+" secs"),
                timeout, timeout, TimeUnit.SECONDS);
        scheduler.schedule(() -> {
            System.out.println("Initiating shutdown");
            scheduler.shutdown();
        }, bufferTime, TimeUnit.SECONDS);

        //If we directly call the method shutdown() after scheduleAtFixedRate(),
        // then the  scheduleAtFixedRate() will not get a chance to execute, unlike shedule() where task is created in a queue and waited for it's termination
        // here it is handled by a period, so we need to call shutdown inside shedule() method giving long enough time delay
        //scheduler.shutdown();
        return ResponseEntity.noContent().build();
    }

}

//NOTE NEW CACHED THREADPOOL
//Executors.newCachedThreadPool() --> Dynamically creates thread according to need and manages them
//just a risk on the number of thread creation is not at the hands of the programmer
//ideal for short load, not lengthy processes
//because more threads -> more CPU usage

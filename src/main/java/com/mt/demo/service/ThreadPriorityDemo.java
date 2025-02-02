package com.mt.demo.service;

import com.mt.demo.service.executables.ThreadPrioritySetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class demonstrating the functionality and effects of thread priorities in Java.
 * This class provides examples or methods to show how thread priorities can influence
 * the scheduling and execution order of threads within a multi-threaded environment.
 *
 * @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
@Service
public class ThreadPriorityDemo {

    /**
     * Demonstrates how thread priorities affect thread execution in Java.
     * This method creates three threads with different priority levels:
     * <li> One with the lowest priority (Thread.MIN_PRIORITY) </li>
     * <li> One with normal priority (Thread.NORM_PRIORITY) </li>
     * <li> One with the highest priority (Thread.MAX_PRIORITY) </li>
     * <br>
     * Each thread is an instance of ThreadPrioritySetter, which is assumed to be a custom class
     * implementing the Runnable interface with a constructor that takes a thread name.
     * The method starts all threads and returns a ResponseEntity with no content, indicating
     * the demonstration of thread priority has been performed.
     *
     * @return A ResponseEntity with no content, indicating the thread priority demonstration has been executed.
     */
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

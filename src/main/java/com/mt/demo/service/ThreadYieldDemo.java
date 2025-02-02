package com.mt.demo.service;

import com.mt.demo.service.executables.ThreadYielder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class demonstrating the functionality of Thread.yield() in Java.
 * This class provides examples or methods to show how the yield() method can be used
 * to suggest that the current thread should yield its execution to other threads,
 * although it's up to the JVM whether to honor this request.
 *
 * @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
@Service
public class ThreadYieldDemo {
    /**
     * Demonstrates the use of the Thread.yield() method in Java.
     * <ul>
     *   <li>Here Thread.yield() method has been called inside run() method of {@link ThreadYielder}'s</li>
     *   <li>yield() method gives a signal/Hint to the JVM to consider giving a chance of execution to other threads waiting</li>
     *   <li>Its upto the JVM whether to entertain that request or not</li>
     * </ul>
     *
     * @return A ResponseEntity with no content, indicating the thread yield demonstration has been performed.
     */
    public ResponseEntity<Void> demoThreadYield() {
        ThreadYielder t1 = new ThreadYielder();
        ThreadYielder t2 = new ThreadYielder();
        t1.start();
        t2.start();
        return ResponseEntity.noContent().build();
    }
}

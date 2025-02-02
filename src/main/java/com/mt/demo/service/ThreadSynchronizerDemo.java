package com.mt.demo.service;

import com.mt.demo.model.Counter;
import com.mt.demo.service.executables.ThreadCounter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Class demonstrating the use of synchronization in Java to manage thread concurrency.
 * This class provides examples or methods to illustrate how synchronization can be
 * applied to ensure thread-safe operations on shared resources, preventing race conditions
 * and ensuring data integrity in multi-threaded scenarios.
 *
 * @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
@Service
public class ThreadSynchronizerDemo {
    /**
     * Demonstrates the use of synchronization in Java to manage thread interactions on shared resources.
     * <ul>
     *   <li>The `increment()` method in the Counter class has been made synchronized to ensure that when multiple threads attempt to modify a shared resource:</li>
     *   <li>- Only one thread can perform the operation at any given time</li>
     *   <li>- This prevents data loss or inaccuracies due to interference between threads</li>
     *   <li>Java's SYNCHRONIZED keyword is used for this purpose:</li>
     *   <li>- If thread t1 is executing `increment()`, thread t2 must wait until t1 completes</li>
     * </ul>
     * <p>Alternatively, a synchronized block can be used if you only need to synchronize part of a method:</p>
     * <pre>
     *     void increment(){
     *         synchronized (this){
     *             count++;
     *         }
     *     }
     * </pre>
     * Here, 'this' refers to the single instance of the object, ensuring thread-safe access to 'count'.
     * Without synchronization, the unpredictable outcome due to concurrent thread execution
     * is known as a RACE CONDITION.
     *
     * @return A ResponseEntity with no content, indicating the synchronization process has been demonstrated.
     */
    public ResponseEntity<Void> demoSynchronization() {
        Counter counter = new Counter();
        ThreadCounter t1 = new ThreadCounter(counter);
        ThreadCounter t2 = new ThreadCounter(counter);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Value of count = " + counter.getCount());
        return ResponseEntity.noContent().build();
    }
}

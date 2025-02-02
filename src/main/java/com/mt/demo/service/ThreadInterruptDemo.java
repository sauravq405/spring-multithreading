package com.mt.demo.service;

import com.mt.demo.service.executables.ThraedInterrupter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class demonstrating the mechanism of thread interruption in Java.
 * This class includes examples or methods to illustrate how threads can be interrupted,
 * how interruptions are handled, and the effects of thread interruption on thread execution.
 *
 * @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
@Service
public class ThreadInterruptDemo {

    /**
     * Demonstrates how to interrupt threads in Java, affecting their current state.
     * <ul>
     *   <li>interrupt() method basically changes the current state of a thread,</li>
     *   <li>which means if a thread is sleeping, disturb the sleep</li>
     *   <li>if a thread is executing, pause the execution</li>
     *   <li>if a thread is waiting, bring it out of wait state</li>
     * </ul>
     *
     * @return A ResponseEntity with no content, indicating the thread interruption demonstration has been performed.
     */
    public ResponseEntity<Void> demoThreadInterrupt() {
        ThraedInterrupter thraedInterrupter = new ThraedInterrupter();
        thraedInterrupter.start();
        thraedInterrupter.interrupt();
        return ResponseEntity.noContent().build();
    }
}

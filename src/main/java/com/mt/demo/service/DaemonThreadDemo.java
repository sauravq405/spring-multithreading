package com.mt.demo.service;

import com.mt.demo.service.executables.DaemonThreadSetter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service class demonstrating the behavior and usage of daemon threads in Java.
 * This class provides examples or utilities to understand how daemon threads operate,
 * particularly focusing on their lifecycle and interaction with the JVM.
 *
 * @author <a href="mailto:sauravq405@gmail.com">sauravq405@gmail.com</a>
 */
@Service
public class DaemonThreadDemo {

    /**
     * Demonstrates the behavior of daemon threads in Java.
     * <ul>
     *   <li>Daemon Threads are background threads</li>
     *   <li>Garbage collector is an example</li>
     *   <li>JVM doesn't wait for daemon threads before shutting down</li>
     *   <li>But JVM does wait for user threads. In this case t is a user thread</li>
     * </ul>
     *
     * @return A ResponseEntity with no content, indicating the daemon thread demonstration has been performed.
     */
    public ResponseEntity<Void> demoDaemonThread() {
        DaemonThreadSetter t = new DaemonThreadSetter();
        t.setDaemon(true);
        t.start();
        System.out.println("Reached end of method: demoDaemonThread()");
        return ResponseEntity.noContent().build();
    }
}

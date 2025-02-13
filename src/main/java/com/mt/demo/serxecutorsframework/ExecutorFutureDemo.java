package com.mt.demo.serxecutorsframework;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class ExecutorFutureDemo {

    public ResponseEntity<Void> demoExecutorFutureDemo() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> 4567);
        if (future.isDone()) {
            System.out.println("Task is done!!");
        }
        if (future.isCancelled()) {
            System.out.println("Task is cancelled!!");
        }
        System.out.println("Future.get() = "+future.get()); //It's a blocking call.
        // It would wait for the task to complete in the run method, fed to submit()
        if (future.isDone()) {
            System.out.println("Task is done!!");
        }
        executor.shutdown();
        return ResponseEntity.noContent().build();
    }
}

package com.mt.demo.serxecutorsframework;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ExecutorFutureDemo {

    public ResponseEntity<Void> demoExecutorFutureDemo() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> 4567; // Callable.call() method is called, since it's returning something.
        Runnable runnable = () -> System.out.println("test-print"); //Runnable.run() method is called, since i's not returning anything.
        Future<?> future = executor.submit(callable);
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

package com.mt.demo.serxecutorsframework;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class ExecutorsTimeoutCancel {
    public ResponseEntity<Void> demoExecutorsTimeoutCancel() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
            System.out.println("Task executing...");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
               Thread.currentThread().interrupt();
               System.out.println("Thread interrupted: "+e.getMessage() + e);
            }
            return 397405;
        };
        Future<Integer> future = executor.submit(callable);
        try {
            //this version of get() method will wait for tasks to be completed within the specified time
            //beyond that
            int i = future.get(1, TimeUnit.SECONDS);
            System.out.println("Value returned: "+i);
        } catch (InterruptedException e) {
            System.out.println("Exception caught: "+e.getMessage() + e);
        } catch (ExecutionException e) {
            System.out.println("Exception caught: "+e.getMessage() + e);
        } catch (TimeoutException e) {
            System.out.println("Exception caught: "+e.getMessage() + e);
        }
        executor.shutdown();
        demoExecutorsCancel();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> demoExecutorsCancel() {
        System.out.println("######Beginning demoExecutorsCancel()######");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> callable = () -> {
            System.out.println("Task executing...");
            try{
                Thread.sleep(2000);
                System.out.println("Inside callable task");
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: "+e.getMessage() + e);
            }
            return 397405;
        };
        Future<Integer> future = executor.submit(callable);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception caught: "+e.getMessage() + e);
        }
        //cancels any executing task -
        future.cancel(true);
        //future.cancel(false);
        System.out.println("future.isCancelled(): "+future.isCancelled());
        System.out.println("future.isDone(): "+future.isDone());
        executor.shutdown();
        return ResponseEntity.noContent().build();
    }
}

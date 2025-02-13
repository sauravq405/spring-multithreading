package com.mt.demo.serxecutorsframework;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Service
public class InvokeAllExecutorsDemo {

    public ResponseEntity<Void> demoInvokeAllExecutors() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };
        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2, callable3);
        try {
            //unlike submit(), invokeAll() method is a blocking call
            executor.invokeAll(callables);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred: "+e.getMessage() + e);
        }
        executor.shutdown();
        System.out.println("###demoInvokeAllExecutors()-completed execution###");
        //demoInvokeAllExecutorsCancellationException();
        demoInvokeAnyExecutors();
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> demoInvokeAllExecutorsCancellationException() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };
        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = null;
        try {
            //unlike submit(), invokeAll() method is a blocking call
            //this will wait for all tasks to complete within 2 seconds irrespective the number of threads
            //for remaining threads cancellation exception is thrown
            futures = executor.invokeAll(callables, 1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred: "+e.getMessage() + e);
        }
        for (Future<Integer> future : futures) {
            try {
                int i = future.get();
                System.out.println("Value returned: "+i);
            } catch (CancellationException e) {
                System.out.println("Exception occurred: "+e.getMessage() + e);
            } catch (InterruptedException e) {
                System.out.println("Exception occurred: "+e.getMessage() + e);
            } catch (ExecutionException e) {
                System.out.println("Exception occurred: "+e.getMessage() + e);
            }
        }
        executor.shutdown();
        System.out.println("###demoInvokeAllExecutorsCancellationException()-completed execution###");
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> demoInvokeAnyExecutors() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Callable<Integer> callable1 = () -> {
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () -> {
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () -> {
            System.out.println("Task 3");
            return 3;
        };
        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2, callable3);
        List<Future<Integer>> futures = null;
        try {
            //it returns the actual data instead of a Future instance
            //whichever task gets completed first is selected
            int i = executor.invokeAny(callables);
            System.out.println("Selected task number: "+i);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred: "+e.getMessage() + e);
        } catch (ExecutionException e) {
            System.out.println("Exception occurred: "+e.getMessage() + e);
        }
        executor.shutdown();
        System.out.println("###demoInvokeAnyExecutors()-completed execution###");
        return ResponseEntity.noContent().build();
    }


}

package com.mt.demo.serxscycompletablefuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class CompletableFutureDemo {
    public ResponseEntity<Void> demoCompletableFuture() throws ExecutionException, InterruptedException {
        //CompletableFuture by default is a daemon thread for doing parallel processing.
        // But you can make it user thread by supplying an ExecutorService instance in the supplyAsync() method.
        // See below:
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        //CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "ok", executor);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" executing inside CompletableFuture0");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
        String s = completableFuture.get();
        System.out.println("completableFuture: "+s);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" executing inside CompletableFuture1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" executing inside CompletableFuture2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });

        //allOf() method gives
        CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);
        System.out.println("allOf: "+allOf.get());

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" executing inside CompletableFuture3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        }).thenApply(x -> x + x);

        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" executing inside CompletableFuture4");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        }).orTimeout(2, TimeUnit.SECONDS).exceptionally(x -> "Timed out");

        //System.out.println("future3"+future3.getNow("default"));
        System.out.println("future3: "+future3.get());
        System.out.println("future4: "+future4.get());

        System.out.println("Main");
        return ResponseEntity.noContent().build();
    }
}

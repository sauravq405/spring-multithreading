package com.mt.demo.serxecutorsframework;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WithoutExecutorsFrameWork {


    public ResponseEntity<Void> demoWithExecutorsFrameWork() {
        long startTime = System.currentTimeMillis();
        //singleThreadedApproach(); //no explicit thread created, relies on executing thread
        multiThreadedApproach(); //explicit thread created, doesn't rely on executing thread
        System.out.println("\nTime taken for calculation: " + (System.currentTimeMillis() - startTime));
        return ResponseEntity.noContent().build();
    }

    private void singleThreadedApproach() {
        for(int i=1; i<10; i++){
            int factorial = factorial(i);
            System.out.println("Factorial of "+i+" = "+factorial);
        }
    }

    private void multiThreadedApproach() {
        Thread[] threads = new Thread[9];
        for(int i=1; i<10; i++){
            int finalI = i;
            threads[i-1] = new Thread(() -> {
                int factorial = factorial(finalI);
                System.out.println("Factorial of "+finalI+" = "+factorial);
            });
            threads[i-1].start();

        }

        //Please note that upon created threads, join() method must be called to ensure complete execution
        // of the threads in READY state, made by invoking start() method.
        //The Thread[] array has been created at the beginning
        // so that same thread can be invoked with start() as well as join()
        //If all these steps are not implemented,
        // then total execution time calculation at the last will always be inaccurate
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private int factorial(int n) {
        //To simulate factorial calculation as a very heavy operation, it is made to sleep for 1 sec
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        int result = 1;
        for (int i = 1; i <= n ; i++){
            result = result * i;
        }
        return result;
    }
}

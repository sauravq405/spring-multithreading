package com.mt.demo.serxscountdownlatch;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class CountDownLatchDemo {

    public ResponseEntity<Void> demoCountDownLatch() throws InterruptedException {
        int noOfServices = 3;
        //CountDownLatch is used to make a set of threads wait for another thread or a set of threads
        // until the countdown is reached
        //based on the number of tasks i.e. submit(), the count of CountdownLatch is decided
        CountDownLatch latch = new CountDownLatch(noOfServices);
        ExecutorService executor = Executors.newFixedThreadPool(noOfServices);
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        // at this point it will wait until the countdown reaches from count to 0
        // and then release it to the main/executing thread
        latch.await();
        System.out.println("Return back to main thread");
        executor.shutdownNow();
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Void> demoCountDownLatchTimeOut() throws InterruptedException {
        int noOfServices = 3;
        CountDownLatch latch = new CountDownLatch(noOfServices);
        ExecutorService executor = Executors.newFixedThreadPool(noOfServices);
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        executor.submit(new DependentService(latch));
        // at this point it will wait for the specified time
        // until the countdown reaches from count to 0
        // and then release it to the main/executing thread
        latch.await(2, TimeUnit.SECONDS);
        System.out.println("Return back to main thread");
        executor.shutdownNow();
        return ResponseEntity.noContent().build();
    }
}

class DependentService implements Callable<String> {
      private final CountDownLatch latch;

      public DependentService(CountDownLatch latch){
          this.latch = latch;
      }
    @Override
    public String call() throws Exception {
        try{
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " service executing");
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}

package com.mt.demo.serxscyclicbarrier;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class CyclicBarrierDemo {

    public ResponseEntity<Void> demoCyclicBarrier() throws BrokenBarrierException, InterruptedException {
        int noOfServices = 3;
        //think of cyclic barrier as a reusable version of countdown latch
        //generally reusable status is maintained by reset() method
        CyclicBarrier barrier = new CyclicBarrier(noOfServices);
        ExecutorService executor = Executors.newFixedThreadPool(noOfServices);
        executor.submit(new DependentService(barrier));
        executor.submit(new DependentService(barrier));
        executor.submit(new DependentService(barrier));
        //Please note
        // It DOES NOT block the main/executing thread
        //It makes the threads wait until all of them has reached the barrier
        //which means in all the threads barrier.await() is called inside call()/run() method
        System.out.println("Return back to main thread");
        executor.shutdown();
        return ResponseEntity.noContent().build();
    }
}

class DependentService implements Callable<String> {
    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " service executing");
        barrier.await();
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
        return "ok";
    }
}

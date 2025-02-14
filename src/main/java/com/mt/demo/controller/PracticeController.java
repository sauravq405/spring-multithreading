package com.mt.demo.controller;

import com.mt.demo.service.*;
import com.mt.demo.serxecutorsframework.*;
import com.mt.demo.serxscheduledexecutors.ScheduledExecutorDemo;
import com.mt.demo.serxscountdownlatch.CountDownLatchDemo;
import com.mt.demo.serxscyclicbarrier.CyclicBarrierDemo;
import com.mt.demo.serxscycompletablefuture.CompletableFutureDemo;
import com.mt.demo.serxsvolatileatomic.AtomicityDemo;
import com.mt.demo.serxsvolatileatomic.VolatileDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@Slf4j
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @Autowired
    private ThreadDemo threadDemo;
    @Autowired
    private ThreadLifecycleDemo threadLifecycleDemo;
    @Autowired
    private ThreadMethodsDemo threadMethodsDemo;
    @Autowired
    private ThreadPriorityDemo threadPriorityDemo;
    @Autowired
    private ThreadInterruptDemo threadInterruptDemo;
    @Autowired
    private ThreadYieldDemo threadYieldDemo;
    @Autowired
    private DaemonThreadDemo daemonThreadDemo;
    @Autowired
    private ThreadSynchronizerDemo threadSynchronizerDemo;
    @Autowired
    private RentrantLockDemo rentrantLockDemo;
    @Autowired
    private RentrantExample rentrantExample;
    @Autowired
    private FairnessInLockDemo fairnessInLockDemo;
    @Autowired
    private ReadWriteLockDemo readWriteLockDemo;
    @Autowired
    private DeadLockDemo deadLockDemo;
    @Autowired
    private ProducerConsumerDemo producerConsumerDemo;
    @Autowired
    private WithExecutorsFrameWork withExecutorsFrameWork;
    @Autowired
    private WithoutExecutorsFrameWork withoutExecutorsFrameWork;
    @Autowired
    private ExecutorFutureDemo executorFutureDemo;
    @Autowired
    private InvokeAllExecutorsDemo invokeAllExecutorsDemo;
    @Autowired
    private ExecutorsTimeoutCancel executorsTimeoutCancel;
    @Autowired
    private ScheduledExecutorDemo scheduledExecutorDemo;
    @Autowired
    private CountDownLatchDemo countDownLatchDemo;
    @Autowired
    private CyclicBarrierDemo cyclicBarrierDemo;
    @Autowired
    private CompletableFutureDemo completableFutureDemo;
    @Autowired
    private VolatileDemo volatileDemo;
    @Autowired
    private AtomicityDemo atomicityDemo;

    @GetMapping("/practice")
    public ResponseEntity<?> practice() {
           return practiceService.practice();
    }

    @GetMapping("/printThreadNames")
    public ResponseEntity<?> printThreadNames() {
        return threadDemo.printThreadNames();
    }

    @GetMapping("/printRunnableNames")
    public ResponseEntity<Void> printRunnableNames() {
        return threadDemo.printRunnableNames();
    }

    @GetMapping("/threadLifecycleDemo")
    public ResponseEntity<Void> demoThreadLifecycle() throws InterruptedException {
        return threadLifecycleDemo.demoThreadLifecycle();
    }

    @GetMapping("/threadMethodsDemo")
    public ResponseEntity<Void> demoThreadMethods() throws InterruptedException {
        return threadMethodsDemo.demoThreadMethods();
    }

    @GetMapping("/threadPriorityDemo")
    public ResponseEntity<Void> demoThreadPriority() {
        return threadPriorityDemo.demoThreadPriority();
    }

    @GetMapping("/threadInterruptDemo")
    public ResponseEntity<Void> demoThreadInterrupt() throws InterruptedException {
        return threadInterruptDemo.demoThreadInterrupt();
    }

    @GetMapping("/threadYieldDemo")
    public ResponseEntity<Void> demoThreadYield()  {
        return threadYieldDemo.demoThreadYield();
    }

    @GetMapping("/daemonThreadDemo")
    public ResponseEntity<Void> demoDaemonThread() throws InterruptedException {
        return daemonThreadDemo.demoDaemonThread();
    }

    @GetMapping("/threadSynchronizerDemo")
    public ResponseEntity<Void> demoSynchronization() throws InterruptedException {
        return threadSynchronizerDemo.demoSynchronization();
    }

    @GetMapping("/rentrantLockDemo")
    public ResponseEntity<Void> demoRentrantLock() throws InterruptedException {
        return rentrantLockDemo.demoRentrantLock();
    }

    @GetMapping("/rentrantExample")
    public ResponseEntity<Void> runReantrant() throws InterruptedException {
        return rentrantExample.runReantrant();
    }

    @GetMapping("/fairnessInLockDemo")
    public ResponseEntity<Void> demoFairnessInLock() throws InterruptedException {
        return fairnessInLockDemo.demoFairnessInLock();
    }

    @GetMapping("/readWriteLockDemo")
    public ResponseEntity<Void> demoReadWriteLock() throws InterruptedException {
        return readWriteLockDemo.demoReadWriteLock();
    }

    @GetMapping("/deadLockDemo")
    public ResponseEntity<Void> demoDeadLock() throws InterruptedException {
        return deadLockDemo.demoDeadLock();
    }

    @GetMapping("/producerConsumerDemo")
    public ResponseEntity<Void> demoProducerConsumer() throws InterruptedException {
        return producerConsumerDemo.demoProducerConsumer();
    }


    @GetMapping("/withoutExecutorsFrameWork")
    public ResponseEntity<Void> demoWithoutExecutorsFrameWork() throws InterruptedException {
        return withExecutorsFrameWork.demoWithoutExecutorsFrameWork();
    }

    @GetMapping("/withExecutorsFrameWork")
    public ResponseEntity<Void> demoWithExecutorsFrameWork() throws InterruptedException {
        return withoutExecutorsFrameWork.demoWithExecutorsFrameWork();
    }

    @GetMapping("/executorFutureDemo")
    public ResponseEntity<Void> demoExecutorFutureDemo() throws InterruptedException, ExecutionException {
        return executorFutureDemo.demoExecutorFutureDemo();
    }

    @GetMapping("/invokeAllExecutorsDemo")
    public ResponseEntity<Void> demoInvokeAllExecutors() throws InterruptedException, ExecutionException {
        return invokeAllExecutorsDemo.demoInvokeAllExecutors();
    }

    @GetMapping("/executorsTimeoutCancel")
    public ResponseEntity<Void> demoExecutorsTimeoutCancel() throws InterruptedException, ExecutionException {
        return executorsTimeoutCancel.demoExecutorsTimeoutCancel();
    }

    @GetMapping("/scheduledExecutorDemo")
    public ResponseEntity<Void> demoScheduledExecutor() throws InterruptedException, ExecutionException {
        return scheduledExecutorDemo.demoScheduledExecutor();
    }

    @GetMapping("/countDownLatchDemo")
    public ResponseEntity<Void> demoCountDownLatch() throws InterruptedException, ExecutionException {
        return countDownLatchDemo.demoCountDownLatch();
    }

    @GetMapping("/cyclicBarrierDemo")
    public ResponseEntity<Void> demoCyclicBarrier() throws InterruptedException, ExecutionException, BrokenBarrierException {
        return cyclicBarrierDemo.demoCyclicBarrier();
    }

    @GetMapping("/completableFutureDemo")
    public ResponseEntity<Void> demoCompletableFuture() throws InterruptedException, ExecutionException, BrokenBarrierException {
        return completableFutureDemo.demoCompletableFuture();
    }

    @GetMapping("/volatileDemo")
    public ResponseEntity<Void> demoVolatileDemo() throws InterruptedException, ExecutionException, BrokenBarrierException {
        return volatileDemo.demoVolatileDemo();
    }

    @GetMapping("/atomicityDemo")
    public ResponseEntity<Void> demoAtomicity() throws InterruptedException, ExecutionException, BrokenBarrierException {
        return atomicityDemo.demoAtomicity();
    }

}

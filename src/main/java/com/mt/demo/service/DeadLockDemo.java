package com.mt.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeadLockDemo {
    class Pen{
      public synchronized void writeWithPenAndPaper(Paper paper){
          System.out.println(Thread.currentThread().getName()+" is using pen "+ this + " and is waiting for paper "+paper);
          paper.finishWriting();
      }

      public synchronized void finishWriting(){
          System.out.println(Thread.currentThread().getName()+" finished using pen "+ this);
      }
    }

    class Paper {
        public synchronized void writeWithPaperAndPen(Pen pen){
            System.out.println(Thread.currentThread().getName()+" is using paper "+ this + " and is waiting for pen "+pen);
            pen.finishWriting();
        }

        public synchronized void finishWriting(){
            System.out.println(Thread.currentThread().getName()+" finished using paper "+ this);
        }
    }

    class Task1 implements Runnable{
        Pen pen;
        Paper paper;
        public Task1(Pen pen, Paper paper){
            this.pen = pen;
            this.paper = paper;
        }
        @Override
        public void run() {
            pen.writeWithPenAndPaper(paper); //thread 1 locks pen and tries to lock paper
        }
    }

    class Task2 implements Runnable{
        Pen pen;
        Paper paper;
        public Task2(Pen pen, Paper paper){
            this.pen = pen;
            this.paper = paper;
        }
        @Override
        public void run() {
            synchronized (pen) {//Added synchronized block to release dedlock - this technique is called
                //Implementing a lock ordering strategy where locks are always acquired in the same order.
                //here we are telling compiler to acquire lock of paper first, if you want to use it

                paper.writeWithPaperAndPen(pen); //thread 1 locks paper and tries to lock pen (pre-resolution of deadlock)
            }
        }
    }

    public ResponseEntity<Void> demoDeadLock() {
        Paper paper = new Paper();
        Pen pen = new Pen();
        Thread t1 = new Thread(new Task1(pen, paper), "THREAD-1");
        Thread t2 = new Thread(new Task2(pen, paper), "THREAD-2");
        t1.start();
        t2.start();
        return ResponseEntity.noContent().build();
    }
}

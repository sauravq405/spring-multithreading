package com.mt.demo.service.executables;

public class DaemonThreadSetter extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("Hey Daemon");
        }
    }
}

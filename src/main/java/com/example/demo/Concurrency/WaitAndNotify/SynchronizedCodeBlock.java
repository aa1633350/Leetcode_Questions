package com.example.demo.Concurrency.WaitAndNotify;

public class SynchronizedCodeBlock {

    public synchronized void printTable(int x) throws InterruptedException { //try running the same code after removing synchronized.

        for(int i=1;i<=10;i++) {
            System.out.println(x*i);
            Thread.sleep(2000);
        }

    }
}

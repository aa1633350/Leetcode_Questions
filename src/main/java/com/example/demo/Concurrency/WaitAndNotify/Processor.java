package com.example.demo.Concurrency.WaitAndNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Processor{

//    public synchronized void produce() throws InterruptedException {
//        System.out.println("Producer thread running");
//        wait();
//        System.out.println("Producer thread interruppted");
//    }
//
//    public synchronized void consume() throws InterruptedException {
//        Thread.sleep(2000);
//        notify();
//        System.out.println("Consumer thread ....");
//        Thread.sleep(5000);
//
//    }
    LinkedList<Integer> list = new LinkedList<>();
    private final Object lock = new Object();
    private static final int LIMIT = 10;
    public void produce() throws InterruptedException {
        int value=0;
        while(true) {
            synchronized (lock) {
                while (list.size()==LIMIT) {
                    lock.wait();
                }
                System.out.println("Ran " + value + " no of times");
                list.add(value++);
                lock.notify();
            }

        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while(list.size()==0) {
                    lock.wait();
                }
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is " + value);
                lock.notify();
            }
            //Thread.sleep(2000);
        }
    }


}

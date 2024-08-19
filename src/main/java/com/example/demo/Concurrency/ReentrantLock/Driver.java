package com.example.demo.Concurrency.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Driver {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();
        Thread producerThread1 = new Thread(() -> {
            sharedResource.Produce(lock);
        });

        Thread producerThread2 = new Thread(() -> {

            sharedResource2.Produce(lock);
        });

        producerThread1.start();
        producerThread2.start();
    }
}

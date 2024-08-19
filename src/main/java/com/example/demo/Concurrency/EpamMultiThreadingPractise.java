package com.example.demo.Concurrency;

import com.example.demo.Concurrency.ReentrantLock.SharedResource;

import java.util.concurrent.locks.ReentrantLock;

public class EpamMultiThreadingPractise {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource();
        Thread thread_produce = new Thread( () -> {
            sharedResource.Produce(lock);
        });

        Thread thread_produceTwo = new Thread(()-> {
            sharedResource.Produce(lock);
        });
        thread_produce.start();

        thread_produceTwo.start();
    }
}

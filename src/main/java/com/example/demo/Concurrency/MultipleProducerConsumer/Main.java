package com.example.demo.Concurrency.MultipleProducerConsumer;


import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Semaphore semaphore = new Semaphore(3);
        Semaphore consumerSemaphore = new Semaphore(3);

        Thread t1 = new Thread(() -> {
            System.out.println("Starting producer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.producer(semaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Starting producer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.producer(semaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Starting producer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.producer(semaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c1 = new Thread(() -> {
            System.out.println("Starting consumer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.consumer(consumerSemaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread c2 = new Thread(() -> {
            System.out.println("Starting consumer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.consumer(consumerSemaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread c3 = new Thread(() -> {
            System.out.println("Starting consumer thread "  + Thread.currentThread().getName());
            try {
                sharedResource.consumer(consumerSemaphore);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}

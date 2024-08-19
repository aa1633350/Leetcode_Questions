package com.example.demo.Concurrency.Semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {

    private final Semaphore semaphore = new Semaphore(3);
    volatile int count=0;
    public void accessResource() {
        try {
            semaphore.acquire();
            count++;
            System.out.println(Thread.currentThread().getName() + " is accessing the resource count is "+ count);
            // Simulate some work with the shared resource
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " has released the resource");
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        for (int i = 0; i < 10; i++) {
            new Thread(resource::accessResource).start();
        }
    }
}

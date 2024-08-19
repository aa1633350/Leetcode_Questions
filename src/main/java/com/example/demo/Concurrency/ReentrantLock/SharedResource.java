package com.example.demo.Concurrency.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean resource = false;


    public void Produce(ReentrantLock lock) {
        System.out.println("Attempting to acquire lock by " + Thread.currentThread().getName());
        //System.out.println("Producing resource " + Thread.currentThread().getName());
        lock.lock();
        System.out.println("Lock acquired by "+ Thread.currentThread().getName());
        resource = true;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Is lock held by current thread before release? " + lock.isHeldByCurrentThread());
            lock.unlock();
            System.out.println("Lock released "+ Thread.currentThread().getName());
        }

    }


}

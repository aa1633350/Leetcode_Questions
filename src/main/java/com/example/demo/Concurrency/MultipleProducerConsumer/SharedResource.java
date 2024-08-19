package com.example.demo.Concurrency.MultipleProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;

public class SharedResource {

    volatile Queue<Integer> q = new LinkedList<>();

    public void producer(Semaphore semaphore) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            synchronized (this) {
                while (q.size() == 3) {
                    System.out.println("Producers are waiting !!" + Thread.currentThread().getName());
                    wait();
                }
                int valueProduced = produce();

                System.out.println("Thread " + Thread.currentThread().getName() + " produced value " + valueProduced);
                q.add(valueProduced);
                semaphore.release();
                notifyAll();

            }

        }
    }

    private int produce() {
        return (int) (Math.random() * 100);
    }

    public void consumer(Semaphore semaphore) throws InterruptedException {
        while (true) {
            semaphore.acquire();
            synchronized (this) {
                while (q.size() == 0) {
                    System.out.println("Consumers are waiting !! " + Thread.currentThread().getName());
                    wait();
                }
                int valueConsumed = q.poll();

                System.out.println("Thread " + Thread.currentThread().getName() + " consumed value " + valueConsumed);
                semaphore.release();
                notifyAll();
            }

        }
    }
}

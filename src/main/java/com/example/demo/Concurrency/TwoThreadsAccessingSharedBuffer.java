package com.example.demo.Concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TwoThreadsAccessingSharedBuffer {

    private static final Object lock = new Object();
    private Queue<Integer> queue = new LinkedList<>();
    Random rand = new Random();

    private void produce() {
        synchronized (lock) {
            while(queue.size()>=2) {
                try {
                    System.out.println("Producing done.. Thread 1 is waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int item = rand.nextInt(5);
            System.out.println("Producing: " + item);
            queue.add(item);
            lock.notify();
        }
    }

    private void consume() {
        synchronized (lock) {
            while(queue.isEmpty()) {
                try {
                    System.out.println("Consuming done.. Thread 2 is waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int item = queue.poll();
            System.out.println("Consuming: " + item);
            lock.notify();
        }
    }

    public static void main(String[] args) {
        TwoThreadsAccessingSharedBuffer object = new TwoThreadsAccessingSharedBuffer();
        Thread producer = new Thread(() -> {
            for(int i=0;i<5;i++) {
                object.produce();
            }

        });

        Thread consumer = new Thread(()-> {
            for(int i=0;i<5;i++) {
                object.consume();
            }
        });
        producer.start();
        consumer.start();
    }
}

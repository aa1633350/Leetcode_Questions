package com.example.demo.Concurrency.ProducerConsumer;

import java.util.Queue;

public class SharedResource {

    Queue<Integer> queue;
    int item=0;

    public SharedResource(Queue<Integer> queue) {
        this.queue = queue;
    }

    public synchronized void produceItem() {
        while(queue.size() >=4) {
            System.out.println("Queue is full, producer is waiting !!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Adding Item " + item + " to Queue");
        queue.add(item);
        item++;
        notifyAll();


    }

    public synchronized void consumeItem() {
        while(queue.isEmpty()) {
            System.out.println("Queue is empty, consumer is waiting !!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int consumedItem = queue.remove();
        System.out.println("Removing Item " + consumedItem + " from Queue");
        notifyAll();

    }

    public boolean bufferContainsItem() {
        return queue.isEmpty();
    }
}

package com.example.demo.Concurrency.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        SharedResource sharedResource = new SharedResource(q);
        Thread producerThread = new Thread(()-> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<5;i++) {
                sharedResource.produceItem();
            }

        });

        Thread producerThread2 = new Thread(()-> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<4;i++) {
                sharedResource.produceItem();
            }

        });

        Thread consumerThread = new Thread(()-> {
            for(int i=0;i<5;i++) {
                sharedResource.consumeItem();
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread2 = new Thread(()-> {
            for(int i=0;i<4;i++) {
                sharedResource.consumeItem();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
        producerThread2.start();
        consumerThread2.start();


    }
}

package com.example.demo.Concurrency;

import java.util.concurrent.Semaphore;

public class Starting5ThreadsAndPrintingNumbersAlternating {

//    private static Object lock = new Object();
//    private static int threadNo = 1;
//
//    private static void printNumbersUsing5Threads() {
//        int count = 1;
//        synchronized (lock) {
//            for(int i=1;i<=5;i++) {
//                while(threadNo != i) {
//                    try {
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("Thread " + Thread.currentThread().getId() + " printing " + count);
//                count++;
//                threadNo = (threadNo % 5) + 1;
//                lock.notifyAll();
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        int numberOfThreads = 5;
//        //int limit = 25;
//
//        for (int i = 1; i <= numberOfThreads; i++) {
//            final int threadNumber = i;
//            Thread thread = new Thread(() -> {
//                printNumbersUsing5Threads();
//
//            });
//            thread.start();
//        }
//
//
//    }


    private static final int NUMBER_OF_THREADS = 5;
    private static final int NUMBERS_TO_PRINT = 5; // Total numbers to print by each thread
    private static final Semaphore[] semaphores = new Semaphore[NUMBER_OF_THREADS];

    static {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            semaphores[i] = new Semaphore(0);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            final int threadNumber = i + 1;

            threads[i] = new Thread(() -> {
                for (int j = 1; j <= NUMBERS_TO_PRINT; j++) {
                    int noToBePrinted = j+threadNumber-1;
                    try {
                        semaphores[threadNumber - 1].acquire();
                        System.out.println("Thread " + Thread.currentThread().getId() + " printing " + noToBePrinted);
                        semaphores[(threadNumber % NUMBER_OF_THREADS)].release();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            threads[i].start();
        }

        // Start the first thread in the sequence
        semaphores[0].release();
    }


}

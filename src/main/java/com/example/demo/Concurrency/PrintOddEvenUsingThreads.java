package com.example.demo.Concurrency;

public class PrintOddEvenUsingThreads {
    private static final int N = 10;
    static int counter=1;


//
//    private static void testRun(int val) {
//
//        System.out.println(val);
//        try {
//            Thread.currentThread().wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    private void printOdd() {

        synchronized (this) {

            while(counter < N) {
                System.out.println("VALUE BEING PRINTED BY THREAD " +Thread.currentThread().getName() + " " +counter);
                try {
                    counter++;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName());
                notify();
            }

            //Thread.yield();
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printEven() {

        synchronized (this) {

            while (counter < N) {
                System.out.println("Call coming Even");
                System.out.println("VALUE BEING PRINTED BY THREAD " +Thread.currentThread().getName() + " " +counter);
                counter++;
                notify();

                try {

                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(Thread.currentThread().getName());
            }
        }

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintOddEvenUsingThreads obj = new PrintOddEvenUsingThreads();

        Thread t1 = new Thread(() -> {
            obj.printOdd();
        });
        t1.setName("Ayushi");
        Thread t2 = new Thread(() -> {
            obj.printEven();
        });

        t2.setName("Aditya");
        t1.start();
        t2.start();



//        Thread t3 = new Thread( new Runnable () {
//            @Override
//            public void run() {
//
//            }
//        });
    }
}

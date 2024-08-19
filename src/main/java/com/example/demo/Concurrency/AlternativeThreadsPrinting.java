package com.example.demo.Concurrency;

public class AlternativeThreadsPrinting {

    private static final Object lock = new Object();
    private boolean isFirstName = true;
    private void firstNamePrinter() {

        synchronized (lock) {
            while (!isFirstName) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 1 : Aditya");
            isFirstName = false;
            lock.notify();
        }

    }

    private void lastNamePrintter() {
        synchronized (lock) {

            while(isFirstName) {
                try {
                    System.out.println("Hello");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2 : Anand");
            isFirstName = true;
            lock.notify();
        }
    }

    public static void main(String[] args) {
        AlternativeThreadsPrinting obj = new AlternativeThreadsPrinting();
        Thread th1 = new Thread(() -> {
           for(int i=0;i<5;i++) {
               obj.firstNamePrinter();
           }
        });

        Thread th2 = new Thread(() -> {
            for(int i=0;i<5;i++) {
                obj.lastNamePrintter();
            }
        });

        th1.start();
        th2.start();
    }
}

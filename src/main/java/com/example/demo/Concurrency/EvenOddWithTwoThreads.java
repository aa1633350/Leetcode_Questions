package com.example.demo.Concurrency;

// Java program for the above approach

public class EvenOddWithTwoThreads {

    // Starting counter
    int counter = 1;

    static int N;

    // Function to print odd numbers
    public void printOddNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {

                // If count is even then print
                if (counter % 2 == 0) {

                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println("VALUE BEING PRINTED BY THREAD " +Thread.currentThread().getName() + " " +counter);

                // Increment counter
                counter++;

                // Notify to second thread
                notify();
            }
        }
    }

    // Function to print even numbers
    public void printEvenNumber()
    {
        synchronized (this)
        {
            // Print number till the N
            while (counter < N) {

                // If count is odd then print
                if (counter % 2 == 1) {

                    // Exception handle
                    try {
                        wait();
                    }
                    catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Print the number
                System.out.println("VALUE BEING PRINTED BY THREAD " +Thread.currentThread().getName() + " " +counter);

                // Increment counter
                counter++;

                // Notify to 2nd thread
                notify();
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given Number N
        N = 10;

        // Create an object of class
        EvenOddWithTwoThreads mt = new EvenOddWithTwoThreads();

        // Create thread t1
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                mt.printEvenNumber();
            }
        });
        t1.setName("A");

        // Create thread t2
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                mt.printOddNumber();
            }
        });
        t2.setName("P");
        // Start both threads
        t1.start();
        t2.start();
    }
}

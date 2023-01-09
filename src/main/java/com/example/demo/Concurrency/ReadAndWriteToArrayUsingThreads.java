package com.example.demo.Concurrency;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class ReadAndWriteToArrayUsingThreads {
    int [] arr = new int [5];
    int counter = 10;
    int index = 0;
    private void writeToArray() {

        synchronized (this) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                System.out.println("Please give an input");
                int input = sc.nextInt();
                arr[i] = input;
            }
            System.out.println("Writing to array done successfully");
        }
    }

    private void readFromArray() {
        synchronized (this) {
            for(int i=0;i<5;i++) {
                System.out.println(arr[i]);

            }
        }

        System.out.println("Reading from array done successfully");
    }

    public static void main(String[] args) {
        ReadAndWriteToArrayUsingThreads obj = new ReadAndWriteToArrayUsingThreads();

        Thread t1 = new Thread( () -> {
           obj.writeToArray();
        });

        Thread t2 = new Thread( () -> {
            obj.readFromArray();
        });

        t1.start();
        t2.start();
    }
}

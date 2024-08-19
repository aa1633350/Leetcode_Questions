package com.example.demo.Concurrency;

public class Starting10Threads {

    private static void startNThreads() {
        for(int i=0;i<10;i++) {
            Thread thread = new Thread(()-> {
                System.out.println("Starting thread "  + Thread.currentThread().getId());
            });
            thread.start();
        }
    }


    public static void main(String[] args) {
        startNThreads();
    }


}

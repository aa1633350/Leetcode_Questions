package com.example.demo.Concurrency.WaitAndNotify;

public class Driver {


    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();
        //SynchronizedCodeBlock synchronizedCodeBlock = new SynchronizedCodeBlock();
        Thread thread1 = new Thread(() -> {
            try {
                //synchronizedCodeBlock.printTable(2);
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try {
                processor.consume();
                //synchronizedCodeBlock.printTable(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}

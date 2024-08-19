package com.example.demo.Concurrency;

public class CreateAndStopTwoThreads implements Runnable{

    private boolean exitStatus = false;

    @Override
    public void run() {
        int i=0;
        while (!exitStatus) {
            System.out.println(Thread.currentThread().getName() + " Printed " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        exitStatus = true;
    }

    public static void main(String[] args) {
        CreateAndStopTwoThreads obj = new CreateAndStopTwoThreads();
        Thread t1 = new Thread(obj);
        t1.setName("First Thread");
        t1.start();
        Thread t2 = new Thread(obj);
        t2.setName("Second Thread");
        t2.start();
        obj.stop();
    }
}

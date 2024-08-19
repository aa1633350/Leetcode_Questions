package com.example.demo.Concurrency;

public  class ThreadJoin implements Runnable{


    @Override
    public void run() {

        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Current Thread is " + Thread.currentThread().getName());
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadJoin obj = new ThreadJoin();

        Thread t1 = new Thread(obj);
        t1.setName("Aditya");
        t1.start();
        //t1.join();


        Thread t2 = new Thread(obj);
        t2.setName("Ayushi");
        t2.start();
        //t2.join();
        //System.out.println("Now starting thread 3");
        Thread t3 = new Thread(obj);
        t3.setName("Anand");
        t3.start();
        //t3.join();

        System.out.println(Thread.currentThread().getName());
    }
}

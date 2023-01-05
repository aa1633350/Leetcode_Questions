package com.example.demo.Concurrency;

public class CreateNThreads implements Runnable{
    @Override
    public void run() {
        System.out.println("Running current thread " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {

        int [] arr = {2,1,4,5,8};
        CreateNThreads obj = new CreateNThreads();
        for(int i : arr) {
            Thread t = new Thread(obj);
            t.start();
            try {
                Thread.sleep(i*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

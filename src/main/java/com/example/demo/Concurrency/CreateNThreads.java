package com.example.demo.Concurrency;

public class CreateNThreads extends Thread {
    @Override
    public void run() {
        System.out.println("Running current thread " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        CreateNThreads obj = new CreateNThreads();
        obj.start();
        obj.run();

//        int [] arr = {2,1,4,5,8};
//
//        for(int i : arr) {
//            Thread t = new Thread(obj);
//            t.start();
//            try {
//                Thread.sleep(i*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}

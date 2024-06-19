package com.example.demo.DesignPatterns.Strategy;

public class Driver {

    public static void main(String[] args) {
        Retry retry = new ExponentialRetry();
        retry.runRetry();
    }
}

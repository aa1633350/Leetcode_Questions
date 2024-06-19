package com.example.demo.DesignPatterns.Strategy;

public class ConstantStrategyImpl implements RetryStrategy {
    @Override
    public void retry(int numOfRetry, RetryType retryType) {
        System.out.println("Implemented constant strategy");
    }
}

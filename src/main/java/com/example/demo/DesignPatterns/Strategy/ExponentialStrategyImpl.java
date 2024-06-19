package com.example.demo.DesignPatterns.Strategy;

public class ExponentialStrategyImpl implements RetryStrategy {
    @Override
    public void retry(int numOfRetry, RetryType retryType) {
        System.out.println("Implemented exponential retry");
    }
}

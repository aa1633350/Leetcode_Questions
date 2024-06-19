package com.example.demo.DesignPatterns.Strategy;

public class IncrementalStrategyImpl implements RetryStrategy {
    @Override
    public void retry(int numOfRetry, RetryType retryType) {
        System.out.println("Implemented incremental retry");
    }
}

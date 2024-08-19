package com.example.demo.DesignPatterns.Strategy.StrategyImpl;

import com.example.demo.DesignPatterns.Strategy.RetryType;

public class IncrementalStrategyImpl implements RetryStrategy {
    @Override
    public void retry(int numOfRetry, RetryType retryType) {
        System.out.println("Implemented incremental retry");

    }
}
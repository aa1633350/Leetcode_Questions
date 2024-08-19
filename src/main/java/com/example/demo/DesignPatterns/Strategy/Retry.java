package com.example.demo.DesignPatterns.Strategy;

import com.example.demo.DesignPatterns.Strategy.StrategyImpl.RetryStrategy;

public class Retry {
    RetryStrategy retryStrategy;
    RetryType retryType;
    int numberOfRetry;
    public Retry(RetryStrategy retryStrategy, RetryType retryType, int numberOfRetry) {
        this.retryStrategy = retryStrategy;
        this.retryType = retryType;
        this.numberOfRetry = numberOfRetry;
    }

    public void runRetry() {
        retryStrategy.retry(numberOfRetry, retryType);
    }


}

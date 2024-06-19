package com.example.demo.DesignPatterns.Strategy;

public class ExponentialRetry extends Retry {

    public ExponentialRetry() {
        super(new ExponentialStrategyImpl(), RetryType.EXPONENTIAL, 3);
    }
}

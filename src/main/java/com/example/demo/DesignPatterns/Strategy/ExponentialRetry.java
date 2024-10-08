package com.example.demo.DesignPatterns.Strategy;

import com.example.demo.DesignPatterns.Strategy.StrategyImpl.ExponentialStrategyImpl;

public class ExponentialRetry extends Retry {

    public ExponentialRetry() {
        super(new ExponentialStrategyImpl(), RetryType.EXPONENTIAL, 3);
    }
}

package com.example.demo.DesignPatterns.Strategy;

import com.example.demo.DesignPatterns.Strategy.StrategyImpl.ConstantStrategyImpl;

public class ConstantRetry extends Retry {

    public ConstantRetry() {
        super(new ConstantStrategyImpl(), RetryType.CONSTANT, 10);
    }
}

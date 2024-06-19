package com.example.demo.DesignPatterns.Strategy;

public class ConstantRetry extends Retry {

    public ConstantRetry() {
        super(new ConstantStrategyImpl(), RetryType.CONSTANT, 10);
    }
}

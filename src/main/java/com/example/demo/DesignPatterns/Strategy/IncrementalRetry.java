package com.example.demo.DesignPatterns.Strategy;

public class IncrementalRetry extends Retry {

    public IncrementalRetry() {
        super(new IncrementalStrategyImpl(), RetryType.INCREMENTAL, 5);
    }
}

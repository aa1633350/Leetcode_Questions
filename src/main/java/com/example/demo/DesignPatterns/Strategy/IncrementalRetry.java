package com.example.demo.DesignPatterns.Strategy;

import com.example.demo.DesignPatterns.Strategy.StrategyImpl.IncrementalStrategyImpl;

public class IncrementalRetry extends Retry {

    public IncrementalRetry() {
        super(new IncrementalStrategyImpl(), RetryType.INCREMENTAL, 5);
    }
}

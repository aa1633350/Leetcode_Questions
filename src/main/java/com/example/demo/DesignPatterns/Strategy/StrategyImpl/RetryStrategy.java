package com.example.demo.DesignPatterns.Strategy.StrategyImpl;

import com.example.demo.DesignPatterns.Strategy.RetryType;

public interface RetryStrategy {

    void retry(int numOfRetry, RetryType retryType);
}

package com.example.demo.DesignPatterns.Strategy;

public interface RetryStrategy {

    void retry(int numOfRetry, RetryType retryType);
}

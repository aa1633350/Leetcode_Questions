package com.example.demo.MachineCodingPractice.RateLimiter;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {

    private final long maxTokens; // max capacity of buckets
    private final long tokensPerRefill; // number of tokens in refill
    private final long tokenRefillInterval; // tokens refill interval
    private final AtomicLong tokens; // current tokens
    private final AtomicLong lastRefillTime; // time when bucket was last refilled.

    public TokenBucket(long maxTokens, long tokensPerRefill, long tokenRefillInterval) {
        if(maxTokens < 0 || tokensPerRefill < 0 || tokenRefillInterval < 0) {
            throw new IllegalArgumentException("Please provide positive values");
        }
        this.maxTokens = maxTokens;
        this.tokensPerRefill = tokensPerRefill;
        this.tokenRefillInterval = tokenRefillInterval;
        tokens = new AtomicLong(maxTokens);
        lastRefillTime = new AtomicLong(System.currentTimeMillis());
    }

    public long getCurrentTokens() {
        return tokens.get();
    }

    public boolean tryConsume() {
        refillTokens();
        if(getCurrentTokens() > 0) {
            tokens.getAndDecrement();
            return true;
        }
        return false;

    }

    private void refillTokens() {
        long now = System.currentTimeMillis();
        long lastRefill = lastRefillTime.get();
        if(now - lastRefill >= tokenRefillInterval) {
            long newTokens = Math.min(maxTokens, getCurrentTokens()+tokensPerRefill);
            tokens.set(newTokens);
            lastRefillTime.set(now);
        }
    }
}

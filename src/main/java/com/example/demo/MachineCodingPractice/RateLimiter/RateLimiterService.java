package com.example.demo.MachineCodingPractice.RateLimiter;

public class RateLimiterService {

    TokenBucket tokenBucket;
    RateLimiterService(long maxTokens, long tokensPerRefill, long tokenRefillInterval) {
        tokenBucket = new TokenBucket(maxTokens, tokensPerRefill, tokenRefillInterval);
    }

    private boolean isRequestAllowed() {
        return tokenBucket.tryConsume();
    }

    private long getAvailableTokens() {
        return tokenBucket.getCurrentTokens();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiterService rateLimiterService = new RateLimiterService(4, 2, 1000);
        for(int i=1;i<=15;i++) {
            if(rateLimiterService.isRequestAllowed()) {
                System.out.println("Request " + (i) + ": Allowed");
            } else {
                System.out.println("Request " + (i) + ": Dropped");
            }

            Thread.sleep(200);
        }
    }

}

package com.example.demo.Coding.MachineCoding.RateLimiter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket implements RateLimiter {

    Queue<Integer> requestsQueue;

    public LeakyBucket(int capacity) {
        this.requestsQueue = new LinkedList<>(Collections.singleton(capacity));
    }

    @Override
    public boolean grantAccess() {
        if(requestsQueue.size()<10) {
            requestsQueue.add(1);
            return true;
        }
        return false;
    }
}

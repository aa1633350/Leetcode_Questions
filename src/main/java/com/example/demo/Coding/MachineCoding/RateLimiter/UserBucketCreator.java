package com.example.demo.Coding.MachineCoding.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {

    Map<Integer,LeakyBucket> userBucket;

    public UserBucketCreator(int id) {
        this.userBucket = new HashMap<>();
        userBucket.put(id,new LeakyBucket(10));
    }

    void tryToAccessApplication(int id) throws TooManyRequestException {

        if(userBucket.get(id).grantAccess()) {
            System.out.println("Able to access the application");
        } else {
            String msg = "Too many request from user " + id + " please try after some time";
            throw new TooManyRequestException(msg);
        }

    }
}

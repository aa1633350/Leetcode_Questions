package com.example.demo.Coding.MachineCoding.RateLimiter;

public class Driver {

    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        for(int i=1;i<12;i++) {
            try {
                userBucketCreator.tryToAccessApplication(1);
            } catch (TooManyRequestException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

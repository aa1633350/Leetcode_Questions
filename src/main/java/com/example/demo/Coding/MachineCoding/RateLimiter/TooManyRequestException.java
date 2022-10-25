package com.example.demo.Coding.MachineCoding.RateLimiter;

public class TooManyRequestException extends Exception{

    public TooManyRequestException(String msg) {
        super(msg);
    }
}

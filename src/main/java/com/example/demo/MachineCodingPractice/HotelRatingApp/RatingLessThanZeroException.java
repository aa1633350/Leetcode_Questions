package com.example.demo.MachineCodingPractice.HotelRatingApp;

public class RatingLessThanZeroException extends Exception {

    public RatingLessThanZeroException() {
        super("Rating can't be less than zero.");
    }
}

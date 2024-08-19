package com.example.demo.MachineCodingPractice.HotelRatingApp;

public class Rating {
    private User user;
    private int ratingValue;
    private String optionalReview;

    public Rating(User user, String optionalReview) {
        this.user = user;
        this.optionalReview = optionalReview;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) throws RatingLessThanZeroException{
        if (ratingValue < 0) {
            throw new RatingLessThanZeroException();
        }
        this.ratingValue = ratingValue;
    }

    public String getOptionalReview() {
        return optionalReview;
    }
}

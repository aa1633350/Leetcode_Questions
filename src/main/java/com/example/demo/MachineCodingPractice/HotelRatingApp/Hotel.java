package com.example.demo.MachineCodingPractice.HotelRatingApp;

import java.util.List;

public final class Hotel {

    private String hotelName;
    private List<Rating> rating;
    private boolean isPlusHotel;

    public Hotel(String hotelName, List<Rating> rating, boolean isPlusHotel) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.isPlusHotel = isPlusHotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating.add(rating);
    }

    public boolean isPlusHotel() {
        return isPlusHotel;
    }

    public void setPlusHotel(boolean plusHotel) {
        isPlusHotel = plusHotel;
    }

    public int getAverageRating() {
        int ratingValue = 0;
        for(Rating rate : rating) {
            ratingValue += rate.getRatingValue();
        }
        return ratingValue/rating.size();
    }







}

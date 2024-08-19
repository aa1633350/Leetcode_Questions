package com.example.demo.MachineCodingPractice.HotelRatingApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class HotelManager {

    private List<Hotel> hotels;
    private List<User> users;

    public HotelManager() {
        this.hotels = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    // API'S
    public void addRatingToHotel(String hotelName, User user, int ratingValue, String review) throws RatingLessThanZeroException{
        Hotel hotel = findHotelByName(hotelName);
        if (hotel != null) {
            Rating newRating = new Rating(user,review);
            newRating.setRatingValue(ratingValue);
            hotel.setRating(newRating);
            System.out.println("Rating added successfully");
        } else {
            System.out.println("Hotel not found");
        }
    }

    public void getHotelRatings(String hotelName, RatingEnumFilter ratingEnumFilter, OrderingCriteria orderingCriteria) {
        Hotel hotel = findHotelByName(hotelName);
        List<Rating> hotelRatings = hotel.getRating();
        List<Rating> filteredrating = new ArrayList<>();
        for(Rating rating : hotelRatings) {
            if(rating.getRatingValue() >= ratingEnumFilter.getMaxRating() && rating.getRatingValue() <= ratingEnumFilter.getMinRating()) {
                filteredrating.add(rating);
            }
        }

        switch (orderingCriteria) {
            case RECENT: {
                //filteredrating.sort(Comparator.comparing(Rating.));
                break;
            }
            case ASCENDING: {
                filteredrating.sort(Comparator.comparing(Rating::getRatingValue));
                break;
            }

            case DESCENDING: {
                filteredrating.sort(Comparator.comparing(Rating::getRatingValue).reversed());
                break;
            }
            case DEFAULT: {
                break;
            }
        }

    }

    private Hotel findHotelByName(String hotelName) {
        for(Hotel hotel : hotels) {
            if(hotel.getHotelName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    public User regsiterUser(String userName) {
        if(!userExists(userName)) {
            User user = new User(userName,true);
            users.add(user);
            System.out.println("User added successfully");
            return user;
        } else {
            System.out.println("Username already exists please choose another username");
        }
        return null;
    }

    private boolean userExists(String userName) {
        for(User user : users) {
            if(user.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }


    public Hotel addHotel(String hotelName, boolean isPlusHotel) {
        Hotel hotel = hotelExists(hotelName);
        if(hotel == null) {
            hotel = new Hotel(hotelName,new ArrayList<>(),isPlusHotel);
            hotels.add(hotel);
            System.out.println("Hotel added successfully");
        } else {
            System.out.println("Hotel already exists");
        }
        return hotel;
    }

    private Hotel hotelExists(String hotelName) {
        for(Hotel hotel : hotels) {
            if(hotel.getHotelName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;

    }

    public void describeHotel(String hotelName) {
        Hotel hotel = findHotelByName(hotelName);
        int avgRating = hotel.getAverageRating();
        System.out.println("Hotel [ name= " + hotel.getHotelName() + ", rating = " + avgRating + ", isPlusHotel = " + hotel.isPlusHotel());
    }

    public void listHotels() {

    }
}

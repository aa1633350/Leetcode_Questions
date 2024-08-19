package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

public class Location {

    private String city;
    private String state;
    private int pincode;

    public Location(String city, String state, int pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getPincode() {
        return pincode;
    }
}

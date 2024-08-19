package com.example.demo.MachineCodingPractice.BikeRentalWayfair;

public class Bike extends Product {
    BikeType size;

    Bike(String id, BikeType size) {
        super(id);
        this.size = size;
    }


}

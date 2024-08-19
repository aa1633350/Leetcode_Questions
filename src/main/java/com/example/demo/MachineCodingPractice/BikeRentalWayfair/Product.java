package com.example.demo.MachineCodingPractice.BikeRentalWayfair;

public abstract class Product {
    String id;
    private boolean isRented;
    Product(String id) {
        this.id = id;
        this.isRented = false;
    }

    public String getId() {
        return id;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}

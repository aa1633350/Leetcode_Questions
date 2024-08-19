package com.example.demo.MachineCodingPractice.BikeRentalWayfair;

public class Customer {

    String id;
    String name;
    double amount;

    public Customer(String id, String name, double amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}

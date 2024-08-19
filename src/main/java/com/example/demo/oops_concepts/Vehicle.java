package com.example.demo.oops_concepts;

public class Vehicle {

    private int wheels;
    private int capacity;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void typeOfVehicle() {
        System.out.println("Generic type");
    }
}

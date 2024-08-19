package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

public class Vehicle {

    String vehicleNumber;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    int perDayBookingAmount;

    public Vehicle(String vehicleNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, int perDayBookingAmount) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
        this.perDayBookingAmount = perDayBookingAmount;
    }

    public int getPerDayBookingAmount() {
        return perDayBookingAmount;
    }
}

package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

import java.util.List;

public class VehicleInventory {

    List<Vehicle> storeVehicles;

    public VehicleInventory(List<Vehicle> storeVehicles) {
        this.storeVehicles = storeVehicles;
    }

    public List<Vehicle> getStoreVehicles() {
        return storeVehicles;
    }
}

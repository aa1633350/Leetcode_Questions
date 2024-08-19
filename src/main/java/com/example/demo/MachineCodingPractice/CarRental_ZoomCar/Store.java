package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private Location storeLocation;
    private VehicleInventory storeInventory;
    private List<Reservation> storeReservations;

    public Store(Location storeLocation, VehicleInventory storeInventory) {
        this.storeLocation = storeLocation;
        this.storeInventory = storeInventory;
        this.storeReservations = new ArrayList<>();
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public VehicleInventory getStoreInventory() {
        return storeInventory;
    }

    public Reservation createReservation(Vehicle selectedVehicle, User user) {
        Reservation reservation = new Reservation(1, "20th May",
                "22nd May", "24th May", selectedVehicle, user);
        storeReservations.add(reservation);
        return reservation;
    }
}

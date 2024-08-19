package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

import java.util.List;

public class VehicleRentalSystem {

    private List<User> users;
    private List<Store> stores;

    public VehicleRentalSystem(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    public Store getStore(Location location) throws StoreNotFoundException {
        for(Store currStore : this.stores) {
            if(currStore.getStoreLocation().getPincode() == location.getPincode()) {
                return currStore;
            }
        }
        String message = "Store with pincode " + location.getPincode() + " not found";
        throw new StoreNotFoundException(message);


    }
}

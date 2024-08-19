package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws StoreNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class billClass = Bill.class;
        System.out.println(billClass.getName());
        Bill billObject = (Bill) billClass.newInstance();
        boolean val = billObject.isBillPaid;
        System.out.println(val);
        Method method = billClass.getMethod("isBillPaid");
        System.out.println(method.invoke(billObject));

        // First Create Users;
        List<User> users = addUsers();
        // Now create stores
        List<Store> stores = addStores();

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(users, stores);

        // Now a user comes;
        User user = users.get(0);

        // User searches for a location.
        Location location = new Location("Banglore", "Karnataka", 560048);
        // Search for a store in that location
        Store store = vehicleRentalSystem.getStore(location);
        List<Vehicle> storeVehicles = store.getStoreInventory().getStoreVehicles();

        // Now user makes a reservation of 1st vehicle.
        Vehicle selectedVehicle = storeVehicles.get(0);
        Reservation reservation = store.createReservation(selectedVehicle, user);

        // Generate Bill.
        Bill bill = new Bill();
        bill.setReservation(reservation);
        System.out.println("Is Bill Paid " + bill.isBillPaid());

        Payment payment = new Payment();
        payment.payBill(bill);

        System.out.println("Is Bill Paid " + bill.isBillPaid());

    }

    private static List<Store> addStores() {
        List<Store> newStores = new ArrayList<>();
        List<Vehicle> storeVehicles = new ArrayList<>();
        Location storeLocation1 = new Location("Bengaluru", "Karnataka", 560048);
        Vehicle vehicle = new Car("BR28GB7077", VehicleType.CAR, VehicleStatus.ACTIVE, 9000);
        storeVehicles.add(vehicle);
        VehicleInventory storeInventory = new VehicleInventory(storeVehicles);
        Store store1 = new Store(storeLocation1, storeInventory);
        newStores.add(store1);
        return newStores;
    }

    private static List<User> addUsers() {
        List<User> newUsers = new ArrayList<>();
        User user1 = new User("Aditya", "1000");
        User user2 = new User("Ayushi", "1001");
        newUsers.add(user1);
        newUsers.add(user2);
        return newUsers;


    }
}

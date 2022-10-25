package com.example.demo.Coding.MachineCoding.ParkingLot;

public class Driver {

    public static void main(String[] args) throws ParkingFullException {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.createFloor(1);
        parkingLot.checkForFreeSlotAndPark(1);
        parkingLot.unParkTheVehicle();
    }
}

package com.example.demo.Coding.MachineCoding.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    int floorNumber;
    int numberOfSlots;
    // Ideally it should be mapped floorNumber -> <Slot,Boolean> mapping (Map in Map)
    Map<Integer,Boolean> freeSlots = new HashMap<>();
    ParkingFloor parkingFloor;

    public void generateSlotsOnFloor(int floorNumber, int numberOfSlots) {
        this.floorNumber = floorNumber;
        this.numberOfSlots = numberOfSlots;

        for(int i=0;i<numberOfSlots;i++) {
            freeSlots.put(i,false);
        }
    }

    protected int checkForFreeSlot(int floor) {
        for(Map.Entry<Integer,Boolean> slots : freeSlots.entrySet()) {
            int slotNumber = slots.getKey();
            if(!slots.getValue()) {
                freeSlots.put(slotNumber,true);
                return slotNumber;
            }
        }
        return -1;
    }

    protected void unparkTheVehicle(Ticket ticket,int slotId) {
        freeSlots.put(slotId,false);
        int amountDue = ticket.getAmount();
        System.out.println("Amount for parking your vehicle " +
                ticket.getVehicleNumber() + "is " + amountDue);
    }

    public ParkingFloor getInstance() {
        if(parkingFloor == null) {
            parkingFloor = new ParkingFloor();
        }
        return parkingFloor;
    }


}

package com.example.demo.Coding.MachineCoding.ParkingLot;

import java.util.Scanner;

public class ParkingLot {
    // properties
    // No. of floors
    int floors;
    ParkingFloor parkingFloor = new ParkingFloor();
    Vehicle vehicle;
    Ticket ticket;
    public ParkingLot(int floors) {
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public void addFloor(int floorsAdded) {
        this.floors += floorsAdded;
    }

    public void createFloor(int floors) {

        Scanner sc = new Scanner(System.in);
        for(int i=1;i<=floors;i++) {
            System.out.println("Input the number of slots on floor " + i);
            parkingFloor.generateSlotsOnFloor(i,sc.nextInt());
        }
    }

    protected void checkForFreeSlotAndPark(int floor) throws ParkingFullException {
        int slotId = parkingFloor.checkForFreeSlot(floor);
        if(slotId != -1) {
            // Park the vehicle.
            System.out.println("Vehicle with number " + vehicle.getVehicleNumber() +
                    " parked at " + slotId);
            // Generate ticket.
            System.out.println("Your ticket is " + ticket.getTicketId());
        } else {
            String msg = "The parking of " + floor + " is full !!";
            throw new ParkingFullException(msg);
        }
    }

    protected void unParkTheVehicle() {
        int slotId = ticket.getSlotId();
        parkingFloor.unparkTheVehicle(ticket,slotId);
    }





    // Behaviour
    // add floors
    // add a lot to any floor
    // check for a free lot
}

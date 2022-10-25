package com.example.demo.Coding.MachineCoding.ParkingLot;

import java.util.Date;

public class Ticket {

    int slotId;
    int vehicleNumber;
    int ticketId;
    Date startDateTime;
    Date endDateTime;
    int amount;

    public Ticket(int slotId, int vehicleNumber, int ticketId, int amount) {
        this.slotId = slotId;
        this.vehicleNumber = vehicleNumber;
        this.ticketId = ticketId;
        this.amount = amount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public int getAmount() {
        return amount;
    }

    public int getSlotId() {
        return slotId;
    }
}

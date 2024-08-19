package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

public class Payment {


    public Payment() {

    }

    public void payBill(Bill bill) {
        System.out.println("Please make payment of registration number " + bill.getReservation().getReservationId() + " total amount " + bill.getAmount());
        bill.setBillPaid(true);
    }
}

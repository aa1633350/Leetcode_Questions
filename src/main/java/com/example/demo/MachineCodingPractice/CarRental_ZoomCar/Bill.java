package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

public class Bill {

    private Reservation reservation;
    boolean isBillPaid;

    public void setBillPaid(boolean billPaid) {
        isBillPaid = billPaid;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public Reservation getReservation() {
        return reservation;

    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }


    public int getAmount() {
        Reservation currReservation = this.getReservation();
        Vehicle reservedVehicle = currReservation.getVehicle();
        int perDayBookingAmount = reservedVehicle.getPerDayBookingAmount();
        int numberOfDays = currReservation.getEndDateOfBooking().compareTo(currReservation.getStartDateOfBooking());
        return perDayBookingAmount*numberOfDays;
    }
}

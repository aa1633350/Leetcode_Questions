package com.example.demo.MachineCodingPractice.CarRental_ZoomCar;

public class Reservation {

    private int reservationId;
    private String bookingDate;
    private String startDateOfBooking;
    private String endDateOfBooking;
    private Vehicle vehicle;
    private User user;


    public Reservation(int reservationId, String bookingDate, String startDateOfBooking, String endDateOfBooking, Vehicle vehicle, User user) {
        this.reservationId = reservationId;
        this.bookingDate = bookingDate;
        this.startDateOfBooking = startDateOfBooking;
        this.endDateOfBooking = endDateOfBooking;
        this.vehicle = vehicle;
        this.user = user;
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getStartDateOfBooking() {
        return startDateOfBooking;
    }

    public String getEndDateOfBooking() {
        return endDateOfBooking;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

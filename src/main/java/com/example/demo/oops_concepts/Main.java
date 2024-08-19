package com.example.demo.oops_concepts;

public class Main {

    public static void main(String[] args) {

        Vehicle carObject = new Car();
        //vehicle.typeOfVehicle();
//        Car carObject = new Car();
        carObject.setWheels(4);
        System.out.println("Car has "  + carObject.getWheels() + " wheels.");
        carObject.setCapacity(5);
        carObject.typeOfVehicle();
    }
}

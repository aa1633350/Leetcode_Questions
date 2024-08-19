package com.example.demo.MachineCodingPractice.TransportCalculatorWayfair;

import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        IShipment cargo = new Cargo();

        IPackage standardPkg = new Package(1,10,2,4,"standard");
        IPackage hazardPkg = new Package(6,13,2,4,"harazdous");
        IPackage fragilePkg = new Package(3,15,1,5,"fragile");
        cargo.insertPackage(standardPkg);
        cargo.insertPackage(hazardPkg);
        cargo.insertPackage(fragilePkg);

        double distance = 100; // example distance
        Map<String, Double> costs = cargo.getTotalCosts(distance);
        System.out.println("Total Transport Cost: " + costs.get("Total Transport Cost"));
        System.out.println("Total Service Cost: " + costs.get("Total Service Cost"));
    }
}

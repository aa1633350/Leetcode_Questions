package com.example.demo.MachineCodingPractice.TransportCalculatorWayfair;

import java.util.List;
import java.util.Map;

public interface IShipment {

    void insertPackage(IPackage pkg);
    void remove(int id);
    Map<String, Double> getTotalCosts(double distance);
    List<IPackage> getPackages();
}

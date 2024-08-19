package com.example.demo.MachineCodingPractice.TransportCalculatorWayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cargo implements IShipment {

    List<IPackage> packages;

    public Cargo() {
        this.packages = new ArrayList<>();
    }

    @Override
    public void insertPackage(IPackage pkg) {
        packages.add(pkg);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Map<String, Double> getTotalCosts(double distance) {
        double totalTransportCost = 0;
        double totalServiceCost = 0;
        for(IPackage pkg : packages) {
            double length = pkg.getLength();
            double height = pkg.getHeight();
            double width = pkg.getWidth();
            double weight = pkg.getWeight();
            double volume = length*height*width;
            String pkgTyp = pkg.getPackageType();
            double transportCost = 0.0;
            double serviceCost = 0.0;
            switch (pkgTyp.toLowerCase()) {
                case "standard":
                    transportCost = 0.5 * (volume);
                    serviceCost = 0.5 * weight + 0.5 * distance;
                    break;

                case "harazdous":
                    transportCost = 0.75 * (volume);
                    serviceCost = 0.75 * weight + 0.75 * distance;
                    break;

                case "fragile":
                    transportCost = 0.625 * (volume);
                    serviceCost = 0.625 * weight + 0.625 * distance;
                    break;
            }

            totalTransportCost += transportCost;
            totalServiceCost += serviceCost;
        }
        Map<String, Double> costs = new HashMap<>();
        costs.put("Total Transport Cost", totalTransportCost);
        costs.put("Total Service Cost", totalServiceCost);
        return costs;
    }

    @Override
    public List<IPackage> getPackages() {
        return packages;
    }
}

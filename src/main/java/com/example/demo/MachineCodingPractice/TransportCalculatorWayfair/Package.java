package com.example.demo.MachineCodingPractice.TransportCalculatorWayfair;

public class Package implements IPackage {

    private double length;
    private double height;
    private double width;
    private double weight;
    private String pkgType;
    Package(double length, double height, double width, double weight, String pkgType) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.pkgType = pkgType;
    }
    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public String getPackageType() {
        return pkgType;
    }

    @Override
    public double setHeight() {
        return 0;
    }

    @Override
    public double setLength() {
        return 0;
    }

    @Override
    public double setWidth() {
        return 0;
    }

    @Override
    public double setWeight() {
        return 0;
    }

    @Override
    public String setPackageType() {
        return null;
    }
}

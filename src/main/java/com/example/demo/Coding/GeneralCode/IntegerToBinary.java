package com.example.demo.Coding.GeneralCode;

public class IntegerToBinary {

    String binary(int n) {
        return Integer.toString(n,3);
    }
    public static void main(String[] args) {
        IntegerToBinary obj = new IntegerToBinary();
        System.out.println(obj.binary(12));
    }
}

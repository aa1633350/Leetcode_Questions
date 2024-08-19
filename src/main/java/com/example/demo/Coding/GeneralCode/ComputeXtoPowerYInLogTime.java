package com.example.demo.Coding.GeneralCode;

public class ComputeXtoPowerYInLogTime {

    //Given an integer x and a positive number y, write a function that computes xy under following conditions.
    //a) Time complexity of the function should be O(Log y)
    //b) Extra Space is O(1)
    private int power(int x, int y) {
        int res = 1;


        while(y>1) {
            if(y%2==1) {
                res = res*x;
            }
            y=y/2;
            x=x*x;
        }
        return res*x;
    }
    public static void main(String[] args) {

        ComputeXtoPowerYInLogTime obj = new ComputeXtoPowerYInLogTime();
        System.out.println(obj.power(3,4));
        System.out.println(obj.power(2,5));
        System.out.println(obj.power(2,10));
    }
}

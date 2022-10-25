package com.example.demo.Coding.Recursion;

public class Sum {

    static int val=0;
    public static void main(String[] args) {
        System.out.println(sumIntegers(3));
    }

    private static int sumIntegers(int n) {
        if( n==1){
            return 1;
        }

        return n+sumIntegers(--n);
    }
}


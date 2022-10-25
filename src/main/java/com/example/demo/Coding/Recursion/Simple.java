package com.example.demo.Coding.Recursion;

public class Simple {

    public static void main(String[] args) {
        sayHi(5);
    }

    private static void sayHi(int n) {
        if( n == 0){
            return;
        }
        System.out.println("hi");
        sayHi(--n);
    }
}

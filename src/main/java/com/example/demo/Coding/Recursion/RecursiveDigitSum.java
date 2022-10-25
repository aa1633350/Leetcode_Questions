package com.example.demo.Coding.Recursion;

public class RecursiveDigitSum {

    public static long recur (long n) {
        if(n < 10){
            return n;
        }
        return recur((n%10) + recur(n/10));
    }
    public static int superDigit(String n, int k) {
        long sum=0;
        for ( int i = 0 ; i<n.length(); i++) {
            int digit = n.charAt(i) - '0';
            sum += digit;
        }

        return (int) recur(sum*k);
    }

    // https://www.hackerrank.com/challenges/recursive-digit-sum/problem?isFullScreen=true
    public static void main(String[] args) {
        System.out.println(superDigit("148",3));
    }
}

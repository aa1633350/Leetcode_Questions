package com.example.demo.Coding.Recursion;

public class PrintStairPath {

    public static void main(String[] args) {
        System.out.println(printAllStairPaths(4)); // 111, 12, 21, 3
    }

    private static int printAllStairPaths(int i) {


        if(i==0) {
            return 1;
        }

        if(i<0) {
            return 0;
        }
        return printAllStairPaths(i-1) + printAllStairPaths(i-2) + printAllStairPaths(i-3);

    }
}

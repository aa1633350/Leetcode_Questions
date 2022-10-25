package com.example.demo.Coding.Recursion;

public class IsSorted {

    static boolean sorted (int [] arr, int size, int idx) {

        if(size == idx+1) {
            return true;
        }
        if(arr[idx]>arr[idx+1]) {
            return false;
        }

        return sorted(arr,size,idx+1);
    }
    public static void main(String[] args) {
        int [] arr = {1,5,6,5,5,5};
        System.out.println(sorted(arr,arr.length,0));
    }
}

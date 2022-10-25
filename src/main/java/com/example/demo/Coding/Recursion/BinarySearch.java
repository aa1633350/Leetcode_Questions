package com.example.demo.Coding.Recursion;

public class BinarySearch {

    static boolean binarySearch (int [] arr, int high, int low, int key) {
        int mid = low + (high-low)/2;
        if(low>high) {
            return false;
        }
        if(arr[mid] == key) {
            return true;
        }

        if(arr[mid]>key) {
            return binarySearch(arr,mid-1,low, key);
        } else {
            return binarySearch(arr,high,mid+1, key);
        }

    }
    public static void main(String[] args) {
        int [] arr = {1,5,6,7,9,15,29,34,41};
        System.out.println(binarySearch(arr,arr.length-1,0, 42));
    }
}

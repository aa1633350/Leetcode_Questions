package com.example.demo.Coding.GeneralCode;

public class UpperBoundFunctionBinarySearch {


    private static int upperBound(int arr[], int x) {
        int low = 0,high=arr.length-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] > x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        //int [] arr = {2,3,4,5,6,6,8,9,9,9,9,9,12,14};
        int [] arr = {2,3,4,5,6,7,8,9,9,9,10,10,12,14};
        System.out.println(upperBound(arr,1));
    }
}

package com.example.demo.Coding.GeneralCode;

public class PeakElement {

    public static int peakElement(int[] arr,int n) {

        if((n == 1) || (arr[0]>arr[1]) || (arr[n-1] > arr[n-2])) {
            return 1;
        }

        for(int i=1;i<n-1;i++) {
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        System.out.println(peakElement(arr,3));
    }
}

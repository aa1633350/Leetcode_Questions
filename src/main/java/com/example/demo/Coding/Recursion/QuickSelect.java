package com.example.demo.Coding.Recursion;

public class QuickSelect {

    static int  kthSmallest(int arr[], int low, int r, int k) {
        //code here
        int pivot = arr[r];
        int i = (low - 1);

        for (int j = low; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        int t=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=t;

        int partitionIdx = i+1; // this is i+1th smallest
        if(partitionIdx == k-1) {
            return arr[partitionIdx];
        } else if(partitionIdx > k-1) {
            return kthSmallest(arr,0,partitionIdx-1,k);
        } else {
            return kthSmallest(arr,partitionIdx+1,r,k);
        }

    }

    public static void main(String[] args) {
        int [] arr = { 7,10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr,0,5,3));
    }
}

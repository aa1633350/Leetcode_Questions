package com.example.demo.Coding.Recursion;

import java.util.*;

public class MergeSort {

    static void merge(int [] arr, int low, int high) {

        // left wale array ki length hogi (mid-low+1)
        // right wale ki length hogi (high-mid)

        int mid = low + (high-low)/2;
        int lenLeftPart = mid-low+1;
        int lenRightPart = high-mid;


        int [] leftArr = new int [lenLeftPart];
        int [] rightArr = new int [lenRightPart];

        // copy values

        int k = low;
        for(int i=0;i<lenLeftPart;i++){
            leftArr[i] = arr[k++];
        }
        k=mid+1;
        for(int i=0;i<lenRightPart;i++){
            rightArr[i] = arr[k++];
        }

        // merge two sorted arrays
        int idx1 = 0,idx2=0;
        k=low;
        while(idx1 < lenLeftPart && idx2 < lenRightPart) {
            if(leftArr[idx1] < rightArr[idx2]) {
                arr[k++] = leftArr[idx1];
                idx1++;
            } else {
                arr[k++] = rightArr[idx2];
                idx2++;
            }
        }

        while(idx1<lenLeftPart) {
            arr[k++] = leftArr[idx1];
            idx1++;
        }

        while(idx2<lenRightPart) {
            arr[k++] = rightArr[idx2];
            idx2++;
        }
    }
    private static void mergeSort(int [] arr, int low, int high) {
        if(low>=high){
            return;
        }
        int mid = low + (high-low)/2;
        // this part is essentially dividing the array into 1 element each.
        // pehle lagatar left part create hota hai.
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,high);
    }
    public static void main(String[] args) {
        int [] arr = {38,47,1,8,10,4,6,59};

        mergeSort(arr,0,arr.length-1);
        for(int i : arr) {
            System.out.print(i + " ");
        }
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        System.out.println(firstRow.toUpperCase(Locale.ROOT));
        System.out.println(secondRow.toUpperCase(Locale.ROOT));
        System.out.println(thirdRow.toUpperCase(Locale.ROOT));
    }
}

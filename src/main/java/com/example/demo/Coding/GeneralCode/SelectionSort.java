package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static int lilysHomework(List<Integer> vals) {

        int n = vals.size();
        int swap=0;
        Integer [] arr = vals.toArray(new Integer[0]);
        for(int i=0; i< n-1; i++) {
            int minIdxToBeSwapped = i;
            int min=arr[i];
            int tmp=-1;
            for(int j=i+1;j<n;j++) {

                if(arr[j] < min) {
                    min=arr[j];
                    tmp=j;
                }
            }

            if(tmp!=-1) {
                swap++;
                int temp = arr[minIdxToBeSwapped];
                arr[minIdxToBeSwapped] = arr[tmp];
                arr[tmp] = temp;
            }
        }
        System.out.println(vals.size());
        for (int x : arr) {
            System.out.println(x);
        }
        return swap;

    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(2);
        arr.add(5);
        arr.add(1);
        System.out.println("Final "+lilysHomework(arr));
    }
}

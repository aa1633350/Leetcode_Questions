package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraySortComparator {

    private void sortOnUnitsDigit() {
        Integer [] arr = {30,20,31,47,14,53,67,89,79,69};
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr, (a, b) -> {
            // return 1 means swap values
            if(a%10 > b%10) {
                return 1;
            }
            else if(a%10 == b%10){
                if(Integer.toString(a).charAt(0)-'0' > Integer.toString(b).charAt(0)-'0')
                    return 1;
                else
                    return -1;
            }
            return -1; // -1 one means don't swap
        });
        for (int x:arr) {
            System.out.println(x);
        }
    }

    private static void sort2DArray() {
        int [][] matrix = {{1,3},{2,4},{10,12},{7,12},{8,9}};
        // Sort in descending
        Arrays.sort(matrix, (int [] m1, int [] m2) -> {
            if(m1[1] > m2[1]) {
                return -1;
            } else if(m1[1] == m2[1]) {
                // if second column values are equal then sort on 1st col values in ascending order.
                if(m1[0] > m2[0]) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        });

        for(int [] m : matrix) {
            System.out.println(m[0] + " -> " + m[1]);
        }
    }
    public static void main(String[] args) {
        sort2DArray();
    }
}

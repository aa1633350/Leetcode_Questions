package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;

public class SortA2DArray {

    public static void main(String[] args) {
        int matrix[][] = {{1,3},{2,4},{10,11},{10,12},{8,9}};

        Arrays.sort(matrix, (int [] a1, int [] a2) -> {
            if((a1[1] - a1[0]) < (a2[1] - a2[0])){
                return 1;
            } else if((a1[1] - a1[0]) == (a2[1] - a2[0])){
                return a1[0]-a2[0];
            } else{
                return -1;
            }
        });

        for(int [] a : matrix){
            System.out.println(a[0] + " " + a[1]);
        }


    }
}

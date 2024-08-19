package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomizeArray {

    private void randomizeArray(int [] arr) {
        Random rand = new Random();
        int len = arr.length-1;
        for(int i=len;i>=0;i--) {

            int j = rand.nextInt(i+1);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    private static void formBiggestNumber(List<String> arr) {

        Collections.sort(arr, (X,Y) -> {
            String XY = X+Y;
            String YX = Y+X;
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });

        System.out.println(arr);
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("19");
        arr.add("34");
        arr.add("9");
        arr.add("76");
        arr.add("4");
        System.out.println("23".compareTo("32"));
        formBiggestNumber(arr);
    }
}

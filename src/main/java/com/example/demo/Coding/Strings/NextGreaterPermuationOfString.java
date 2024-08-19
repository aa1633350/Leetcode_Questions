package com.example.demo.Coding.Strings;

import java.util.Arrays;

public class NextGreaterPermuationOfString {

    private static void reverse(char [] arr, int left, int right) {
        while(left<right) {
            char ch = arr[left];
            arr[left] = arr[right];
            arr[right] = ch;
            left++;
            right--;
        }
    }

    private static void nextGreater(String s) {

        char [] arr = s.toCharArray();
        int i=s.length()-2;
        while(i>=0 && arr[i]>=arr[i+1]) {
            i--;
        }
        int j=arr.length-1;
        if(i>=0) {

            while(j>=0 && arr[i]>=arr[j]) {
                j--;
            }
        }
        char ch = arr[j];
        arr[j] = arr[i];
        arr[i] = ch;

        reverse(arr, i+1, s.length()-1);


        System.out.println(Arrays.toString(arr));


    }

    public static void main(String[] args) {
        nextGreater("43251");
    }
}

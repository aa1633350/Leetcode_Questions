package com.example.demo.Coding.Recursion;

public class LinearSearch {

    static boolean linearSearch (int [] arr, int size, int idx, int key) {

        if(arr[idx] == key) {
            return true;
        }
        if(size == idx+1) {
            return false;
        }

        return linearSearch(arr,size,idx+1, key);
    }
    public static void main(String[] args) {
        int [] arr = {1,5,6,5,9,5};
        System.out.println(linearSearch(arr,arr.length,0, 9));
    }
}

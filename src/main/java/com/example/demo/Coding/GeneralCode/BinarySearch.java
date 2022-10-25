package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    static boolean binarySearch(int num, int [] arr) {

        int low = 0, high = arr.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(arr[mid]==num) {
                arr[mid]=-1;
                return true;
            } else if (arr[mid] > num) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;

    }
    public static void main(String[] args) {

        int [] nums2 = {0,4,9,5};
        Arrays.sort(nums2);
        int [] nums1 = {9,4,9,8,4,5,5,1,0};
        //List<Integer> list = new ArrayList<>();
        for(int i : nums1) {
            //System.out.println("Loop" + i);
            if (binarySearch(i, nums2)) {
                System.out.println(i);
                //list.add(i);
            }
        }
    }
}

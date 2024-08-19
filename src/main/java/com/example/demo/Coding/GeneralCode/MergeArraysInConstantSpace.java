package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;

public class MergeArraysInConstantSpace {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=0,j=0;
        while(i<nums1.length && j<n && m<nums1.length) {

            if (nums1[i] >= nums2[j]) {
                nums1[m++] = nums1[i];
                nums1[i] = nums2[j];
                j++;
            }
            i++;
        }

        while(nums1[m]==0) {
            nums1[m++]=nums2[j++];
        }

    }

    public static void main(String[] args) {
        MergeArraysInConstantSpace constantSpace = new MergeArraysInConstantSpace();
        int [] arr = {1,2,3,0,0,0};
        int [] arr2 = {2,5,6};
        constantSpace.merge(arr,3,arr2, 3);
    }
}

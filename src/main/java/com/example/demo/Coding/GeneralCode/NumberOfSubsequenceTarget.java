package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;

public class NumberOfSubsequenceTarget {

    public static int numSubseq(int[] nums, int target) {


        Arrays.sort(nums);
        int low=0,high=nums.length-1,subsequenceLength=0,n=nums.length;
        // single wala bhi compute krna hai
        while(low<high) {
            if(nums[high]+ nums[low] > target) {
                high--;
            }else {
                subsequenceLength = (high-low)+1;
                break;
            }

        }
        int numOfSubsequence = (int)Math.pow(2,subsequenceLength) - 1 - subsequenceLength;
        for(int i=0;i<nums.length;i++) {
            if(2*nums[i]<=target) {
                numOfSubsequence++;
            }
        }

        return numOfSubsequence;


    }

    public static void main(String[] args) {
        numSubseq(new int []{3,5,6,7},9);
    }
}

package com.example.demo.Coding.GeneralCode;

public class SplitArrayLargestSum {

    private static boolean isValid(int[] nums, int mid, int m) {
        int partition = 1;
        int tempSum = 0;
        for(int i=0;i<nums.length;i++) {

            tempSum += nums[i];
            if(tempSum>mid) {
                partition++;
                tempSum=nums[i];
            }

            if(partition>m) {
                return false;
            }

        }
        return true;
    }
    public static int splitArray(int[] nums, int m) {


        // low will be largest element in array and high is sum of array
        int low=-1,high=0;

        for(int i : nums) {
            low = Math.max(low,i);
            high+=i;
        }

        int mid=0;
        while(low<=high) {


            mid = low + (high-low)/2;

            if(isValid(nums,mid,m)) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int [] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums,2));
    }
}

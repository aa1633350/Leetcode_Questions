package com.example.demo.Coding.GeneralCode;

public class ProductOfTwoBiggestNumberInArray {

    public static int maxProduct(int[] nums) {

        int first = nums[0], second = 0;

        for(int i=1;i<nums.length;i++) {
            if(nums[i]>=first) {
                second = first;
                first = nums[i];
            }

            else if(nums[i]>second && nums[i]<first) {
                second = nums[i];
            }
        }

        return (second)*(first);
    }

    public static void main(String[] args) {
        int [] arr = {1,5,4,5};
        System.out.println(maxProduct(arr));
    }
}

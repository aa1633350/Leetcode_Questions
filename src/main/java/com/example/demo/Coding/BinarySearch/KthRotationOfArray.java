package com.example.demo.Coding.BinarySearch;

public class KthRotationOfArray {

    static int findKRotation(int nums[], int n) {
        int low=0,high=n;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(mid>0 && mid<(n-1) && nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1]) {
                return mid;
            }
            else if(nums[mid]>nums[low]) {
                low=mid;
            } else {
                high=mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] num = {4,5,1,2,3};
        System.out.println(findKRotation(num,5));
    }
}

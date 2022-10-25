package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class ThreeSumBaby {

    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        //List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> tempSet = new HashSet<>();
        for(int i=0;i<n-2;i++) {
            int left = i+1;
            int right = n-1;
            //int x = nums[i];

            //int threeSome;
            while(left<right) {
                //List<Integer> tempList = new ArrayList<>();
                int threeSome = nums[i]+nums[left]+nums[right];
                if(threeSome==0) {
                    tempSet.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                } else if(threeSome > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(tempSet);
    }
}

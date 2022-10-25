package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int k=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n,k++);
        }
        //Arrays.sort(nums);


        for(int n : nums) {
            if(map.containsKey(target-n)) {
                int idx1=map.get(n);
                int idx2= map.get(target-n);
                if(idx1!=idx2) {
                    return new int []{idx1,idx2};
                } else {
                    int p=0;
                    for(int x : nums) {
                        if(x==n) {
                            idx2=p;
                            break;
                        }
                        p++;
                    }
                    if(idx1!=idx2){
                        return new int []{idx1,idx2};
                    }

                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        System.out.println((-1 % 4));
        //twoSum(nums,6);

        int [] arr = new int [6];
        Arrays.fill(arr,-1);
        for(int i : arr) {
            System.out.println(i);
        }
    }

}

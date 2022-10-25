package com.example.demo.Coding.GeneralCode;


import java.util.*;

public class MaxSumPairWithEqualDigit {

    public static int maximumSum(int[] nums) {

        Map<Integer, List<Integer>> values = new HashMap<>();

        for(int i=0;i<nums.length;i++) {

            int val = nums[i];
            int sumOfDigits=0;
            while(val>0) {
                sumOfDigits+=val%10;
                val/=10;
            }

            if(values.containsKey(sumOfDigits)) {
                List<Integer> temp = values.get(sumOfDigits);
                temp.add(nums[i]);
                values.put(sumOfDigits, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                values.put(sumOfDigits, temp);
            }
        }
        int ans=-1;
        for(Map.Entry<Integer, List<Integer>> entry : values.entrySet()) {
            List<Integer> temp = entry.getValue();
            if(temp.size()>1){
                int first = temp.get(0);
                int second = 0;
                for(int i=1 ; i<temp.size();i++) {
                    int val = temp.get(i);
                    if(val >= first){
                        second = first;
                        first = val;
                    } else if(val > second && val<first) {
                        second = val;
                    }
                }
                ans = Math.max(ans,second+first);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr = {18,43,36,13,7,1111111,34,52};
        System.out.println(maximumSum(arr));
    }
}

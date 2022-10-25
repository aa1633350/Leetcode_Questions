package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfArrayOfInts {

    private void allPermutations(int[] nums, boolean [] used, List<List<Integer>> ans, List<Integer> temp) {

        if(temp.size()==nums.length) {
            List<Integer> l = new ArrayList<>();
            for(int j : temp) {
                l.add(j);
            }
            if(!ans.contains(l)){
                ans.add(l);
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            temp.add(nums[i]);
            allPermutations(nums,used,ans,temp);
            temp.remove(temp.size()-1);
            used[i]=false;
        }


    }
    public List<List<Integer>> permute(int... nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        boolean [] used = new boolean [n];

        allPermutations(nums,used,ans,temp);
        return ans;
    }

    public static void main(String[] args) {
        AllPermutationOfArrayOfInts arrayOfInts = new AllPermutationOfArrayOfInts();
        int [] nums = {1,2,1};
        List<List<Integer>> ans = arrayOfInts.permute(nums);
        for(List<Integer> l : ans){
            System.out.println(l);
        }
    }
}

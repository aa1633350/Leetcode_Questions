package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    private boolean solve(int idx, int [] nums, List<Integer> temp, List<List<Integer>> ans) {

        if(idx == nums.length) {
            ans.add(new ArrayList<>(temp));
            return true;
        }
        // exclude
        solve(idx+1,nums,temp, ans);

        // include
        temp.add(nums[idx]);
        solve(idx+1,nums,temp, ans);
        temp.remove(temp.size()-1);
        return false;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        solve(0,nums,tempList, ans);
        return ans;
    }

    public static void main(String[] args) {
        int [] num = {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> ans = subsets.subsets(num);
        for(List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}

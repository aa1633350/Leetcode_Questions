package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationsOfANumber {

    public static void main(String[] args) {
        List<String> combinations = new ArrayList<>();
        int num = 1296;
        int [] arr = new int [] {1,2,9,6,8};
        backtrack(arr, 0, new StringBuilder(), combinations);
        for(String combi : combinations) {
            System.out.println(combi);
        }

    }

    private static void backtrack(int[] nums, int index, StringBuilder current, List<String> combinations) {
        if (index >= nums.length) {
            if (current.length() > 0) {
                combinations.add(current.toString());
            }
            return;
        }

        int currentLength = current.length();
        if (currentLength > 0) {
            current.append(",");
        }
        current.append(nums[index]);
        backtrack(nums, index + 1, current, combinations);
        current.delete(currentLength, current.length());

        if (index < nums.length - 1) {
            int twoDigitNumber = nums[index] * 10 + nums[index + 1];
            current.append(",");
            current.append(twoDigitNumber);
            backtrack(nums, index + 2, current, combinations);
            current.delete(currentLength, current.length());
        }
    }
}

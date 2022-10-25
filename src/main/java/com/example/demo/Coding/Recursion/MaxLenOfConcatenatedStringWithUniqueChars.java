package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLenOfConcatenatedStringWithUniqueChars {


    private static boolean isUnique(String str) {
        if (str.length() > 26) return false;
        boolean[] used = new  boolean [26];
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (used[ch - 'a']){
                return false;
            } else {
                used[ch -'a'] = true;
            }
        }
        return true;
    }
    public static int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();
        res.add("");
        int maxVal = 0;
        for (String currStr : arr) {
            if (!isUnique(currStr)) continue;
            List<String> resList = new ArrayList<>();
            for (String candidate : res) {
                String temp = candidate + currStr;
                if (isUnique(temp)) {
                    maxVal = Math.max(temp.length(),maxVal);
                    resList.add(temp);
                }
            }
            res.addAll(resList);
        }
//        int ans = 0;
//        for (String str : res) ans = Math.max(ans, str.length());
        return maxVal;
    }

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("aa","bb","uedr");
        System.out.println(maxLength(strings));
    }
}

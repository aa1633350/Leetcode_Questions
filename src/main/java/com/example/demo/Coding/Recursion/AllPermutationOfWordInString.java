package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutationOfWordInString {

    private static void permute(List<?> arr, int len, List<String> arrList, String ans, boolean[] used) {

        if(len == arr.size()) {
            arrList.add(ans);
            return;
        }
        for(int i=0;i<arr.size(); i++) {
            if(used[i]){
                continue;
            }
            used[i]=true;
            permute(arr,len+1,arrList,ans+arr.get(i),used);
            used[i]=false;

        }
    }

    public static void main(String[] args) {
        String s = "Sky is blue";
        List<String> arr = Arrays.asList(s.split(" "));
        List<String> list = new ArrayList<>();
        boolean [] used = new boolean[arr.size()];

        // Generates all permutation of words in string
        permute(arr,0,list, "", used);
        for(String x : list){
            System.out.println(x);
        }

    }
}

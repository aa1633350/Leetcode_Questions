package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinationOfArrayOfStrings {

    private static void allPossibleCombination(List<String> strings, List<String> ans, String str, int idx, boolean[] used) {

        // base case
        if(idx == strings.size()) {
            ans.add(str);
            return;
        }

        // include
        for(int i=0;i<strings.size();i++) {
            if(used[i]) {
                continue;
            }
            used[i]=true;
            allPossibleCombination(strings,ans,str+" "+strings.get(i),idx+1,used);
            used[i]=false;
        }


    }
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("un","iq","uedr");
        List<String> ans = new ArrayList<>();
        boolean [] used = new boolean[strings.size()];
        allPossibleCombination(strings,ans,"",0,used);
        for(String s : ans) {
            System.out.println(s);
        }
    }
}

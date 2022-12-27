package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubstringOfSting {

    public static String allPermutations(String str) {
        //int n = str.length();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            String subStr="";

            // Second loop is generating sub-String
            for (int j = i; j < str.length(); j++) {
                subStr += str.charAt(j);
                if(subStr.compareTo(ans) > 0) {
                    ans = subStr;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        System.out.println(allPermutations("banana"));
    }
}

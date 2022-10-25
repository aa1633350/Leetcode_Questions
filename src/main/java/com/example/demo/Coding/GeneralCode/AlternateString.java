package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class AlternateString {

    public static int alternate(String s) {
        int[] nums=s.chars().distinct().toArray();
        String res="";
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                char a=(char)('a'+i);
                char b=(char)('a'+j);
                String cur="";
                for(int k=0;k<s.length();k++){
                    if (s.charAt(k)==a || s.charAt(k)==b) {
                        cur+=s.charAt(k);
                    }
                }
                if (cur.length()<res.length()) continue;
                if (isGood(cur)) res=cur;
            }
        }
        return  res.length();
    }
    public static boolean isGood(String s){
        if (s.length()==1) return false;
        for(int i=1;i<s.length();i++){
            if (s.charAt(i)==s.charAt(i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }
}

package com.example.demo.Coding.Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringAllUniqueChars {

    private static int longestSubString(String s) {


        Map<Character,Integer> map = new HashMap<>();
        int currLen = 0,maxLen = 0, lastRepeat = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)) {

                currLen = i- (lastRepeat == 0 ? map.get(ch) : lastRepeat-1);

                map.put(ch,i);
                lastRepeat = i;
            } else {
                map.put(ch,i);
                currLen++;
            }

            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubString("geeksforgeeks"));
    }
}

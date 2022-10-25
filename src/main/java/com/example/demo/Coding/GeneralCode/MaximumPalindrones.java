package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class MaximumPalindrones {

    public static void initialize(String s, int l, int r) {

        String substr = s.substring(l-1,r);
        System.out.println(substr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<substr.length();i++) {
            if(map.containsKey(s.charAt(i))){
                int tempFreq = map.get(s.charAt(i));
                tempFreq+=1;
                map.put(s.charAt(i),tempFreq);
            } else {
                map.put(s.charAt(i),1);
            }
        }
        pq.addAll(map.values());

        for (Integer integer : pq) {
            System.out.println(integer);
        }

        while(substr.length() > 0) {
            char [] arr = new char[substr.length()];
            int left=0, right = substr.length()-1;
            while(left<right){
                int maxFreq = pq.poll();
                //if(maxFreq)
            }
        }
    }

    public static void main(String[] args) {
        initialize("weeksss",1,7);
    }
}

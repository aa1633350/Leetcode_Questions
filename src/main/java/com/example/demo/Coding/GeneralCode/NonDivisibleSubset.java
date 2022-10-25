package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        Set<Integer> distinctVals = s.stream().collect(Collectors.toSet());
        //System.out.println(distinctVals);
        for ( int i =0 ;i < s.size(); i++) {
            int beginVal = s.get(i);
            for (int j = i+1 ; j<s.size(); j++) {
                if((beginVal + s.get(j)) % k == 0) {
                    distinctVals.remove(s.get(j));
                }
            }
        }
        return distinctVals.size();
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(7);
        s.add(2);
        s.add(4);
        System.out.println(nonDivisibleSubset(3,s));
    }
}

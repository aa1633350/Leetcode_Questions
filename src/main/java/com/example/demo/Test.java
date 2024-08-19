package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Test {


    // Need to find what is the first breaking release.
    // API, Jan to Dev (1-12) --> True or false
    // everytime you make a call to this API
    // Running the code take several minutes

    // Queue, the 1st release Jan,Feb,Mar, April
    // Stack, the 1st release [Nov, Oct, Sept, August, April, March, Feb, Jan]
    // Unidentified issue (
    // methodRunCode(Nov) --> true or false.
    // Naive thing check each O(n)
    // Two pointers -> left and right --> O(n/2).
    // Binary Search O(log n).


    // Problem 2.
    // Anagrams (hello oelh)

    // char [] array1 --> length 26 chars
    // h -> 0
    // e -> 0
    // l -> 1
    // o -> 0
    // a -> ....

    // O(n+m)


    // All characters are possible , big document.
    // Map<Charcater,int> -----> ASCII (65536)
    // . -> 5
    // 1 -> 4
    // $ -> 2

    // After processing the second document.
    // . -> 0
    // 1 -> 0
    // $ -> 0

    //            if(frequency.containsKey(ch)) {
//                int currFrequncy = frequency.get(ch);
//                currFrequncy++;
//                frequency.put(ch,currFrequncy);
//            } else {
//                frequency.put(ch,1);
//            }




    private boolean isAnagram(String firstString, String secondString) {
        Map<Character, Integer> frequency = new HashMap<>();
        for(char ch : firstString.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch,0)+1);
        }

        for(char ch : secondString.toCharArray()) {
            if(frequency.containsKey(ch)) {
                int currFrequncy = frequency.get(ch);
                currFrequncy--;
                if(currFrequncy < 0) {
                    return false;
                }
                if(currFrequncy == 0) {
                    frequency.remove(ch);
                }
                frequency.put(ch,currFrequncy);
            } else {
                return false;
            }
        }

        return true;


    }




    // 10000 test cases , if one API call everything after than will fail.
    // 1-10000
    // 4550th case -> if this fails then we know for sure that , the follwoing test cases will also fail.
    // if now we proceed ahead.


    private int getFirstFailureCase(int testCases) {

        int lowerBound=1,upperBound = testCases;

        while(lowerBound < upperBound) {
            int midTestCaseNumber = lowerBound + (upperBound - lowerBound)/2; // 5000

            if(findTestCaseResult(midTestCaseNumber)) {
                lowerBound = midTestCaseNumber+1;
            } else {
                upperBound = midTestCaseNumber-1;
            }
        }

    return 0;

    }

    private boolean findTestCaseResult(int testCase) {
        return true;
    }



}

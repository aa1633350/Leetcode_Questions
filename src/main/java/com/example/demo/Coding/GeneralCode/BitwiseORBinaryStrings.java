package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BitwiseORBinaryStrings {

    public static List<Integer> acmTeam(List<String> topic) {
        int max = -1;
        HashMap<Integer, Integer> check = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for ( int i =0 ; i<topic.size()-1 ; i++) {
            String strOne = topic.get(i);
            for( int j = i+1 ; j<topic.size(); j++ ) {
                String strTwo = topic.get(j);
                int knownTopic=0;

                for ( int k = 0 ; k< strOne.length(); k++) {
                    int val = (strOne.charAt(k) - '0' | strTwo.charAt(k) - '0');
                    if(val == 1) {
                        knownTopic++;
                    }
                }
                if (knownTopic > max){
                    max = knownTopic;
                }
                System.out.println("Max is :" + max);
                if (!check.containsKey(max)) {
                    check.put(max, 1);
                }
                else {
                    int val = check.get(max) + 1;
                    check.put(max, val);
                }

            }
        }
        System.out.println(check);
        System.out.println("----------------------------");
        result.add(max);
        result.add(check.get(max));
        return result;
    }

    public static void main(String[] args) {
        List<String> binary = new ArrayList<>();
        binary.add("10101");
        binary.add("11100");
        binary.add("11010");
        binary.add("00101");
        System.out.println(acmTeam(binary));

    }

}

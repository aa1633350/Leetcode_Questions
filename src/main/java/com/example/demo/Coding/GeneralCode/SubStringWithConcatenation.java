package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenation {
    private static void permute(String[] words, int start, List<String> listOfAllPermutations, String str, boolean[] used) {
        if (start == words.length && !listOfAllPermutations.contains(str)) {
            listOfAllPermutations.add(str);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permute(words, start + 1, listOfAllPermutations, str + words[i], used);
            used[i] = false;
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {


        Map<String, List<Integer>> map = new HashMap<>();
        int len = words.length, lengthOfEachWord = words[0].length();
        boolean[] used = new boolean[len];
        List<String> listOfAllPermutations = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            String subStrWord = s.substring(i, Math.min(i + (lengthOfEachWord * len), s.length()));
            if(subStrWord.length() == len * lengthOfEachWord) {
                if (map.containsKey(subStrWord)) {
                    List<Integer> foundIdxs = map.get(subStrWord);
                    foundIdxs.add(i);
                    map.put(subStrWord, foundIdxs);
                } else {
                    List<Integer> one = new ArrayList<>();
                    one.add(i);
                    map.put(subStrWord, one);
                }
            }
        }
//        for (Map.Entry<String, List<Integer>> values : map.entrySet()) {
//            System.out.println(values.getKey() + ":" + values.getValue());
//        }
        permute(words, 0, listOfAllPermutations, "", used);
//        for(String q : listOfAllPermutations) {
//            System.out.println(q);
//        }
        List<Integer> indices = new ArrayList<>();
        for (String word : listOfAllPermutations) {
            if (map.containsKey(word)) {
                indices.addAll(map.get(word));
            }

            // int idx = s.indexOf(word);
            // if(idx > -1 && !indices.contains(idx)){
            //     indices.add(idx);
            //     s=s.substring(counter*i,s.length());
            // }
            // i++;

        }
        return indices;
    }

    public static void main(String[] args) {
        String s = "bcabbcaabbccacacbabccacaababcbb";

        //"lingmindraboofooowingdingbarrwingmonkeypoundcake
        String [] words = {"c","b","a","c","a","a","a","b","c"};
        System.out.println(findSubstring(s,words));
    }
}


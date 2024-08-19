package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class UberCyclicShift {

    public static int solution(int[] a) {
        int count = 0;

        // Group numbers by their lengths
        Map<Integer, List<String>> lengthGroups = new HashMap<>();
        for (int num : a) {
            String strNum = String.valueOf(num);
            int length = strNum.length();
            lengthGroups.computeIfAbsent(length, k -> new ArrayList<>()).add(strNum);
        }

        // Process each length group separately
        for (List<String> group : lengthGroups.values()) {
            Map<String, Integer> cyclicMap = new HashMap<>();
            for (String num : group) {
                // Generate all cyclic shifts and store in the set to avoid duplicates
                Set<String> cyclicShifts = new HashSet<>();
                String concatenated = num + num;
                int len = num.length();
                for (int i = 0; i < len; i++) {
                    cyclicShifts.add(concatenated.substring(i, i + len));
                }

                // Increment count for each unique cyclic shift
                for (String shift : cyclicShifts) {
                    cyclicMap.put(shift, cyclicMap.getOrDefault(shift, 0) + 1);
                }
            }

            // Count pairs
            for (int value : cyclicMap.values()) {
                if (value > 1) {
                    count += value * (value - 1) / 2; // Combination of pairs
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {13, 5604, 31, 2, 13, 4560, 546, 654, 456};
        System.out.println(solution(a));  // Output should be 5
    }
}

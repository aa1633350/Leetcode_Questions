package com.example.demo.Coding.GeneralCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MicrosoftGraph {

    public int solution(int[] A, int[] B, int N) {
        // Array to store the degree (number of roads) of each city
        int[] degree = new int[N + 1];
        // Map to track the direct connections
        Map<Integer, Set<Integer>> directConnections = new HashMap<>();

        // Populate the degree array and direct connections
        for (int i = 0; i < A.length; i++) {
            degree[A[i]]++;
            degree[B[i]]++;
            directConnections.computeIfAbsent(A[i], k -> new HashSet<>()).add(B[i]);
            directConnections.computeIfAbsent(B[i], k -> new HashSet<>()).add(A[i]);
        }

        int maxNetworkRank = 0;

        // Calculate the maximal network rank
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int networkRank = degree[i] + degree[j];
                // If there is a direct road between the two cities, subtract 1
                if (directConnections.getOrDefault(i, Collections.emptySet()).contains(j)) {
                    networkRank--;
                }
                maxNetworkRank = Math.max(maxNetworkRank, networkRank);
            }
        }

        return maxNetworkRank;
    }

    public static void main(String[] args) {
        MicrosoftGraph sol = new MicrosoftGraph();

        int[] A1 = {1, 2, 3, 3};
        int[] B1 = {2, 3, 1, 4};
        int N1 = 4;
        System.out.println(sol.solution(A1, B1, N1)); // Output: 4

        int[] A2 = {1, 2, 4, 5};
        int[] B2 = {2, 3, 5, 6};
        int N2 = 6;
        System.out.println(sol.solution(A2, B2, N2)); // Output: 2
    }
}

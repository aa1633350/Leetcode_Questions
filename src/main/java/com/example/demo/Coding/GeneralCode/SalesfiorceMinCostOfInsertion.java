package com.example.demo.Coding.GeneralCode;

public class SalesfiorceMinCostOfInsertion {

    private static int calculateCostWithInsertion(int[] arr, int pos, int newValue) {
        int n = arr.length;
        int cost = 0;

        // Add the cost for elements before the insertion point
        for (int i = 1; i < pos; i++) {
            cost += (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]);
        }

        // Add the cost for the new element insertion
        if (pos > 0 && pos < n) {
            cost += (newValue - arr[pos - 1]) * (newValue - arr[pos - 1]);
            cost += (arr[pos] - newValue) * (arr[pos] - newValue);
        } else if (pos == 0) {
            cost += (arr[0] - newValue) * (arr[0] - newValue);
        } else if (pos == n) {
            cost += (arr[n - 1] - newValue) * (arr[n - 1] - newValue);
        }

        // Add the cost for elements after the insertion point
        for (int i = pos; i < n - 1; i++) {
            cost += (arr[i + 1] - arr[i]) * (arr[i + 1] - arr[i]);
        }

        return cost;
    }

    public static int minCostAfterInsertion(int[] arr) {
        int n = arr.length;
        int originalCost = calculateCost(arr);
        int minCost = Integer.MAX_VALUE;

        // Consider inserting at each possible position
        for (int i = 0; i <= n; i++) {
            for (int newValue = 1; newValue <= 100; newValue++) {
                int newCost = calculateCostWithInsertion(arr, i, newValue);
                minCost = Math.min(minCost, newCost);
            }
        }
        return minCost;
    }

    private static int calculateCost(int[] arr) {
        int cost = 0;
        for (int i = 1; i < arr.length; i++) {
            cost += (arr[i] - arr[i - 1]) * (arr[i] - arr[i - 1]);
        }
        return cost;
    }


    public static void main(String[] args) {

        int[] arr = {4,7,1,4};
        long result = minCostAfterInsertion(arr);
        System.out.println(result);
    }
}

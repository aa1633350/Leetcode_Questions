package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;

public class BitonicDe_shaw {

    public static int getMinOperations(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            int target = n - i - 1;
            sum += Math.abs(arr[i] - target);
            sum += Math.abs(arr[n - i - 1] - target);
        }
        return sum;
    }

        public static void main(String[] args) {
            int[] arr = {0, 1, 3, 2, 1};
            System.out.println(getMinOperations(arr));  // Output: minimum number of operations

            int[] arr1 = {3, 3, 3, 3, 3};
            System.out.println(getMinOperations(arr1));
        }


}

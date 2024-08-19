package com.example.demo.Coding.GeneralCode;

//A substring is a group of contiguous characters in a string. For instance, all substrings of abc are [a, b, c, ab, bc, abc]..
//        Given a binary representation of a number, determine the total number of substrings present that match the following conditions:
//        1. The 0s and 1's are grouped consecutively (e.g., 01, 10, 0011, 1100, 000111, etc.).
//        2. The number of 0s in the substring is equal to the number of 1's in the substring.
//        Example
//        5 = 001101
//        The 4 substrings matching the two conditions include [0011, 01, 10, 01]. Note that 01 appears twice, from indices 1-2 and 4-5. There are other substrings, e.g. 001 and 011 that match the first condition but not the second.
//        Function Description
//        Complete the function counting in the editor below.
//        counting has the following parameter(5):
//        strings: a string representation of a binary integer
//        Returns
//        int: the number of substrings of s that satisfy the two conditions

public class SalesforceBinaryCounter {

    public static int counting(String s) {
        int n = s.length();
        int count = 0; // To count the valid substrings
        int prevCount = 0; // To store the count of previous group of '0's or '1's
        int currCount = 1; // To store the count of current group of '0's or '1's

        // Iterate over the string starting from the second character
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If the current character is same as the previous one, increment the current count
                currCount++;
            } else {
                // If the current character is different, add the minimum of prevCount and currCount to the result
                count += Math.min(prevCount, currCount);
                // Update prevCount to currCount and reset currCount to 1
                prevCount = currCount;
                currCount = 1;
            }
        }
        // Add the last group counts
        count += Math.min(prevCount, currCount);

        return count;
    }

    public static void main(String[] args) {
        String binaryString = "10001";
        System.out.println(counting(binaryString)); // Output: 4
    }

}

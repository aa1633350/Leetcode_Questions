package com.example.demo.Coding.GeneralCode;

public class MinFlipToMakeStringMonotone {

    class Solution {
        public int minFlipsMonoIncr(String s) {
            //intuition : reach first one
            //after reaching first one I can count the number of zeros : those zeros are having possibility to get flipped
            //if count of 0s > count of 1s -> will flip ones

            int n = s.length();
            if(s == null || n == 0)
                return 0;

            int countOfOnes = 0;
            int countOfZeros = 0;
            char[] arr = s.toCharArray();

            for(int i = 0; i < n; i++){
                char c = arr[i];
                if(c == '0') {
                    if(countOfOnes == 0)
                        continue;
                    else
                        countOfZeros++;
                } else {
                    countOfOnes++;
                }

                countOfZeros = Math.max(countOfOnes, countOfZeros);
//                if (countOfZeros > countOfOnes) {
//                    countOfZeros = countOfOnes;
//                }

            }
            return countOfZeros;
        }
    }
}

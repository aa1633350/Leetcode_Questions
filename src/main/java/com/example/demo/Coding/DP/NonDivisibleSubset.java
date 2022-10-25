package com.example.demo.Coding.DP;

import java.util.ArrayList;
import java.util.List;

public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> s) {

        int [][] dp = new int [s.size()][s.size()];
        int max =-1;
        for(int i=0;i<s.size();i++){
            for(int j=0;j<s.size();j++){
                if(i<j){
                    if((s.get(i)+s.get(j))% k != 0) {
                        int pivot = s.get(j);
                        boolean flag = true;
                        for(int p=j-1;p>i;p--) {
                            if((pivot + s.get(p)) % k !=0) {
                                continue;
                            } else {
                                dp[i][j] = dp[i][j-1];
                                flag=false;
                            }
                        }
                        if(flag) {
                            dp[i][j] = dp[i][j-1]+1;
                        }
                    }
                    if(dp[i][j] > max){
                        max=dp[i][j];
                    }
                }
            }
        }

        for(int i=0;i<s.size();i++){
            for(int j=0;j<s.size();j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return max;


    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(7);
        arr.add(2);
        arr.add(4);
        /*arr.add(24);
        arr.add(25);
        arr.add(22);*/
        System.out.println(nonDivisibleSubset(3,arr));
    }
}

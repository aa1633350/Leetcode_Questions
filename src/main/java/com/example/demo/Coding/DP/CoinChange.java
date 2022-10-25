package com.example.demo.Coding.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoinChange {

    public static long getWays(int n, List<Long> c) {
        int row = c.size()+1;
        int col = n+1;
        long [][] dp = new long [row][col];

        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                if (c.get(i-1)==j) {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]) +1;
                } else if (c.get(i-1) > j) {
                    dp[i][j] = dp[i-1][j];
                } else if (c.get(i-1) < j) {
                    int tmp = c.get(i-1).intValue();
                    dp[i][j] = dp[i-1][j] + dp[i][j-tmp];
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        List<Long> coin = new ArrayList<>();
        coin.add(1L);
        coin.add(5L);
        coin.add(10L);
        //coin.add(6L);
        Collections.sort(coin);
        System.out.println(getWays(10,coin));
    }
}

//96190959

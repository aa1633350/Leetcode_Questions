package com.example.demo.Coding.DP;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
    static boolean ans = false;
    private static void canJump(boolean[] dp, int jump, int pos, Map<Integer, Integer> values, long maxValue) {
        if(pos >= maxValue) {
            ans=true;
            return;
        }
        dp[pos]=true;

        if(values.containsKey(pos+jump+1) && !dp[pos+jump+1]) {
            canJump(dp,jump+1, pos+jump+1, values, maxValue);
            dp[pos+jump+1]=false;
        }

        if(values.containsKey(pos+jump) && !dp[pos+jump]) {
            canJump(dp,jump, pos+jump, values, maxValue);
            dp[pos+jump]=false;
        }

        if(values.containsKey(pos+jump-1) && !dp[pos+jump-1]) {
            canJump(dp,jump-1, pos+jump-1, values, maxValue);
            dp[pos+jump-1]=false;
        }

    }
    private static boolean canCross(int[] stones) {
        Map<Integer,Integer> values = new HashMap<>();
        int maxValue=0;
        for(int i : stones) {
            maxValue=Math.max(i,maxValue);
            values.put(i,1);
        }

        int currJump=0;
        boolean [] dp;
        if(maxValue==Integer.MAX_VALUE) {
            dp = new boolean [21474];
        } else {
            dp = new boolean [maxValue+1];
        }


        dp[0]=true;



        if(values.containsKey(currJump+1)) {
            canJump(dp,currJump+1, 1,values, maxValue);
        } else {
            return false;
        }
        return ans;
    }

    public static void main(String[] args) {

        //int [] num = {0,1,3,5,6,8,12,17};
        int [] num = {0,2147483647};
        System.out.println(canCross(num));
    }
}

package com.example.demo.Coding.DP;

import java.util.HashMap;
import java.util.HashSet;
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
        int [] num = {0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30};
        System.out.println(canJump(num));
    }

    public static boolean canJump(int[] stones) {
        if(stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Map<Integer, HashSet<Integer>> stonesPos = new HashMap<>();
        for(int s : stones) {
            stonesPos.put(s, new HashSet<>());
        }
        stonesPos.get(stones[0]).add(0);
        for(int stone : stones) {
            System.out.print("Stone "+ stone + " Jump -> ");
            HashSet<Integer> possibleJumps = stonesPos.get(stone);

            for(int jump : possibleJumps) {
                System.out.print(jump + ", ");
                for(int i=-1;i<=1;i++) {
                    int nextJump = jump+i;

                    if(nextJump > 0) {
                        int nextStone = stone + nextJump;
                        if(stonesPos.containsKey(nextStone)) {
                            stonesPos.get(nextStone).add(nextJump);
                        }
                    }
                }
            }
            System.out.println();
        }

        return !stonesPos.get(stones[n-1]).isEmpty();

    }




























    // Contact
    // First -> Aditya
    // Last -> Anand
    // no -> 998765432
    // email ->


    // AdityaAnand998765432
    // RahulKant123456789

    // An
    //

    // Brute Force takes long time and space

    // Trie -> an

    // List<Contacts> list

    // Aditya -> "an"
    // Anand -> "an"
    // 998765432 -> "an"
    //





}

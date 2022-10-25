package com.example.demo.Coding.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGame4 {

    static int jumps = Integer.MAX_VALUE;
    private static int dfs(Map<Integer,List<Integer>> values, int start, int n, int[] arr, boolean [] visited){

        if(start==n) {
            return 1;
        }
        if(start<0 || start>n || visited[start]) {
            return 0;
        }
        visited[start]=true;
        int loop=0;
        for(int i=0; i<values.get(arr[start]).size(); i++) {
            if(!visited[values.get(arr[start]).get(i)]){
                loop=dfs(values,values.get(arr[start]).get(i),n, arr, visited)+1;
            }

        }
        int right = dfs(values,start+1,n, arr, visited)+1;
        int left = dfs(values,start-1,n, arr, visited)+1;


        jumps = Math.min(jumps,loop+left+right);
        return jumps;


    }

    public static int minJumps(int[] arr) {


        Map<Integer, List<Integer>> values = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            List<Integer> temp;
            if(values.containsKey(arr[i])) {
                temp = values.get(arr[i]);
            } else {
                temp = new ArrayList<>();
            }
            temp.add(i);
            values.put(arr[i],temp);
        }
//        for(Map.Entry<Integer,List<Integer>> entry : values.entrySet()) {
//            System.out.println(entry.getKey() + "------>" + entry.getValue());
//        }
        boolean [] visited = new boolean [arr.length];
        return dfs(values,0,arr.length-1,arr,visited);
    }

    public static void main(String[] args) {
        int [] num = {100,-23,-23,404,100,23,23,23,3,404};
        //int [] num = {6,1,9};
        System.out.println(minJumps(num));
    }
}

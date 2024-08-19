package com.example.demo.Coding.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LongestPathWithDiffAdjChars {

    //int cost=0;
    static int cost;
    private static void dfs(int child,  Map<Integer, List<Integer>> graph, boolean[] visited, Map<Integer, Character> map) {
        if (visited[child]) {
            return;
        }
        visited[child] = true;
        if (graph.get(child) != null) {
            for (int node : graph.get(child)) {
                if (map.get(node) != map.get(child)) {
                     cost++;
                     dfs(node,graph,visited,map);
                }

            }
        }

        //return ;
    }

    public static int longestPath(int[] parent, String s) {

        Map<Integer, Character> map = new HashMap<>();
        map.put(-1, '-');
        for (int i = 0; i < s.length(); i++) {
            map.put(i, s.charAt(i));
        }

        // contruct graph.
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i < parent.length; i++) {
            graph.computeIfAbsent(parent[i], l -> new ArrayList<>()).add(i);
            graph.computeIfAbsent(i, l -> new ArrayList<>()).add(parent[i]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println("Source Node :" + entry.getKey() + " Childs " + entry.getValue());
        }
        //return 3;
        int nOfNodes = parent.length;
        int ans = -1;
        for (int i = 0; i < nOfNodes; i++) {
            boolean[] visited = new boolean[nOfNodes];
            cost=0;
            dfs(i, graph, visited, map);
            ans = Math.max(ans, cost);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 0};
        String s = "aabc";
        longestPath(parent, s);
    }
}

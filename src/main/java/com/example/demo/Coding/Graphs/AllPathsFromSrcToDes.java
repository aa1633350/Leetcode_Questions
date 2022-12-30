package com.example.demo.Coding.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPathsFromSrcToDes {

        List<List<Integer>> allPaths = new ArrayList<>();
        private void dfs(int[][] graph, boolean [] visited, int src, int dest, List<Integer> temp) {
            temp.add(src);
            visited[src]=true;
            if(src == dest-1) {
                allPaths.add(new ArrayList<>(temp));
                return;
            }
            for(int l : graph[src]) {

                if(!visited[l]) {
                    dfs(graph,visited,l,dest,temp);
                }
                visited[l]=false;
                temp.remove(temp.size()-1);
            }
        }
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            Map<Integer, List<Integer>> g = new HashMap<>();
            int n = graph.length;
            boolean [] visited = new boolean [n];
            dfs(graph, visited, 0, n, new ArrayList<>());
            return allPaths;

        }

}

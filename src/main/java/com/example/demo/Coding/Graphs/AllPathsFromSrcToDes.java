package com.example.demo.Coding.Graphs;

import java.util.*;

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

    public static void main(String[] args) {
        int i = 150;
        Integer a = i;
        Integer b = i;
        //System.out.println(a.equals(b));
//        String x = "vishal";
//        System.out.println((int)x.charAt(0));
//        String[] myArray = {"JavaFX", "HBase", "OpenCV", "Aava", "Hadoop","Neo4j"};
//        Arrays.sort(myArray);
//        for(String s : myArray) {
//            System.out.println(s);
//        }
        String x = "bcdaiz";
        System.out.println(x);
        char [] ch = x.toCharArray();
        Arrays.sort(ch);
        String sorted = new String(ch);
        System.out.println(sorted);

    }

}

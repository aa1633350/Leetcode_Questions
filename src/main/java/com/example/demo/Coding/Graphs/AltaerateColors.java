package com.example.demo.Coding.Graphs;

import java.util.*;

public class AltaerateColors {

    class Node {
        int curr_Node;
        int color;
        int path;
        Node(int curr_Node, int color) {
            this.curr_Node = curr_Node;
            this.color = color;
        }

        Node(int curr_Node, int color, int path) {
            this(curr_Node,color);
            this.path = path;
        }
    }
    //private int bfs()
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {


        Map<Integer, List<Node>> g = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        for(int [] e : redEdges) {
            int src = e[0];
            int dest = e[1];

            g.computeIfAbsent(src, l -> new ArrayList<>()).add(new Node(dest,-1));
        }

        for(int [] e : blueEdges) {
            int src = e[0];
            int dest = e[1];

            g.computeIfAbsent(src, l -> new ArrayList<>()).add(new Node(dest,-2));
        }
        boolean [] visitedRed = new boolean[n];
        visitedRed[0]=true;
        boolean [] visitedBlue = new boolean[n];
        visitedBlue[0]=true;
        int [] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        //bfs(0,g,visited);
        q.add(new Node(0, -10, 0));

        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Node curr = q.poll();
                int currNode = curr.curr_Node;
                int currColor = curr.color;
                int currPathValue = curr.path;
                if (currColor == -1) { // Red node
                    visitedRed[currNode] = true;
                }

                if (currColor == -2) {
                    visitedBlue[currNode] = true;
                }
                if(g.get(currNode) != null) {
                    for(Node node : g.get(currNode)) {
                        if(currNode == node.curr_Node && currNode != 0) { // self loop
                            if(currColor != node.color) {
                                //if(node.color == )
                                //visited[node.dest] = true;
                                if (currColor == -1) { // Red node
                                    visitedRed[node.curr_Node] = true;
                                }

                                if (currColor == -2) {
                                    visitedBlue[node.curr_Node] = true;
                                }
                                q.add(new Node (node.curr_Node,node.color, currPathValue+1));
                                //ans[node.dest] = currPathValue+1;
                            }
                        }
                        else if(!visitedRed[node.curr_Node] || !visitedBlue[node.curr_Node]) {
                            if(currColor != node.color) {
                                //System.out.println("Node being processed " + node.dest + " color " + node.color);
                                //visited[node.dest] = true;
                                if (node.color == -1) { // Red node
                                    visitedRed[node.curr_Node] = true;
                                }

                                if (node.color == -2) {
                                    visitedBlue[node.curr_Node] = true;
                                }
                                q.add(new Node (node.curr_Node,node.color, currPathValue+1));
                                ans[node.curr_Node] = Math.min(ans[node.curr_Node], currPathValue+1);
                            }
                        }
                        // else if(visited[node.dest] && currColor != node.color) {
                        //     q.add(new Node (node.dest,node.color, currPathValue+1));

                        // }
                    }
                }

            }
        }
        return ans;

    }

    public static void main(String[] args) {
        AltaerateColors obj = new AltaerateColors();
        int [][] red = {{0,1},{1,2},{2,3},{3,4}};
        int [][] blue = {{1,2},{2,3},{3,1}};
        int [] x = obj.shortestAlternatingPaths(5,red,blue);
        for(int i : x) {
            System.out.print(i + " ");
        }
    }
}

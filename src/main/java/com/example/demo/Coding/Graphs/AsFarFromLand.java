package com.example.demo.Coding.Graphs;

import com.example.demo.InterfaceCheck.A;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AsFarFromLand {

    static class Node {

        int x;
        int y;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    private boolean isValid(int x, int y, int size) {

        if(x>=0 && x<size && y>=0 && y<size) {
            return true;
        }
        return false;

    }
    public int maxDistance(int[][] grid) {

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    Node node = new Node(i, j);
                    q.add(node);
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            while (size-- > 0) {

                Node curr = q.poll();
                // if(visited.contains(curr)) {
                //     continue;
                // }
                int currX = curr.x;
                int currY = curr.y;
                //for (int i=0;i<4;i++) {

                if (isValid(currX+1,currY, grid.length) && grid[currX+1][currY] == 0 ) {
                    Node newNode = new Node(currX + 1, currY);
                    if (!visited.contains(newNode)){
                        q.add(newNode);
                        visited.add(newNode);
                        flag = true;
                    }
                }

                if (isValid(currX-1,currY, grid.length) && grid[currX-1][currY] == 0) {

                    Node newNode = new Node(currX - 1, currY);
                    if(!visited.contains(newNode)) {
                        q.add(newNode);
                        visited.add(newNode);
                        flag = true;
                    }

                }

                if (isValid(currX,currY+1, grid.length) && grid[currX][currY+1] == 0) {

                    Node newNode = new Node(currX, currY + 1);
                    if(!visited.contains(newNode)) {
                        q.add(newNode);
                        visited.add(newNode);
                        flag = true;
                    }
                }

                if (isValid(currX,currY-1, grid.length) && grid[currX][currY-1] == 0) {
                    Node newNode = new Node(currX, currY - 1);
                    if(!visited.contains(newNode)) {
                        q.add(newNode);
                        visited.add(newNode);
                        flag = true;
                    }
                }

                //}
            }
            if (flag) {
                level++;
            }
        }
        return level;

    }

    public static void main(String[] args) {
        AsFarFromLand far = new AsFarFromLand();
        int [][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(far.maxDistance(grid));
    }
}

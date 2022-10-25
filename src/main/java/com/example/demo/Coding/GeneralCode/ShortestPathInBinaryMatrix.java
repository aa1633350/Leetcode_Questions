package com.example.demo.Coding.GeneralCode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    private static boolean isValid(int i , int j, int n) {

        return i >= 0 && j >= 0 && i < n && j < n;
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(0,0);
        q.add(p);
        grid[0][0]=2;
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ans++;
            while(size-- > 0) {
                Pair pair = q.poll();
                int r = pair.i;
                int c = pair.j;
                if(r==n-1 && c==n-1) {
                    return ans;
                }
                if(isValid(r-1,c-1,n) && grid[r-1][c-1]==0) {
                    grid[r-1][c-1]=2;
                    Pair obj = new Pair(r-1,c-1);
                    q.add(obj);
                }

                if(isValid(r-1,c,n) && grid[r-1][c]==0) {
                    grid[r-1][c]=2;
                    Pair obj = new Pair(r-1,c);
                    q.add(obj);
                }

                if(isValid(r-1,c+1,n) && grid[r-1][c+1]==0) {
                    grid[r-1][c+1]=2;
                    Pair obj = new Pair(r-1,c+1);
                    q.add(obj);

                }

                if(isValid(r,c+1,n) && grid[r][c+1]==0) {
                    grid[r][c+1]=2;
                    Pair obj = new Pair(r,c+1);
                    q.add(obj);
                }

                if(isValid(r,c-1,n) && grid[r][c-1]==0) {
                    grid[r][c-1]=2;
                    Pair obj = new Pair(r,c-1);
                    q.add(obj);
                }

                if(isValid(r+1,c+1,n) && grid[r+1][c+1]==0) {
                    grid[r+1][c+1]=2;
                    Pair obj = new Pair(r+1,c+1);
                    q.add(obj);
                }
                if(isValid(r+1,c-1,n) && grid[r+1][c-1]==0) {
                    grid[r+1][c-1]=2;
                    Pair obj = new Pair(r+1,c-1);
                    q.add(obj);
                }

                if(isValid(r+1,c,n) && grid[r+1][c]==0) {
                    grid[r+1][c]=2;
                    Pair obj = new Pair(r+1,c);
                    q.add(obj);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int matrix[][] = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] matrix = {{0,1,1},{0,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(matrix));
    }
}

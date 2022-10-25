package com.example.demo.Coding.Recursion;

public class CountSubIslands {

    private void dfs(int[][] grid1, int[][] grid2, int x, int y, int flag) {

        if(x<0 || y<0 || x>=grid1.length || y>=grid1[0].length || grid2[x][y] == 0) {
            return;
        }
        if(grid2[x][y]==1) {
            if(grid1[x][y]==0) {
                flag = 0;
                return;
            }
            grid2[x][y] = 0;
        }
        dfs(grid1,grid2, x+1,y,flag);
        dfs(grid1,grid2, x,y+1,flag);
        dfs(grid1,grid2, x-1,y,flag);
        dfs(grid1,grid2, x,y-1,flag);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int row = grid1.length, col = grid1[0].length;
        int count = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                int flag = 1;
                if(grid2[i][j]!=0) {
                    dfs(grid1,grid2,i,j,flag);
                    if(flag==1) {
                        count++;
                    }
                }

            }
        }
        return count;
    }
    public static void main(String[] args) {


    }
}

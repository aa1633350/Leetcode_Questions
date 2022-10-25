package com.example.demo.Coding.GeneralCode;

public class NumberOfIslands {
    static int islands = 0;
    private static void islandHelper(char[][] grid, int row, int col, int x, int y) {

        if(x<0 || x>=row || y<0 || y>=col || grid[x][y]=='0' || grid[x][y]=='2') {
            return;
        }

        grid[x][y]='2';

        islandHelper(grid,row,col,x+1,y);
        islandHelper(grid,row,col,x,y+1);
        islandHelper(grid,row,col,x-1,y);
        islandHelper(grid,row,col,x,y-1);

    }

    public static int numIslands(char[][] grid) {


        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j]=='1') {
                    islandHelper(grid,row,col,i,j);
                    islands++;
                }

            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char matrix[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(matrix));
    }
}

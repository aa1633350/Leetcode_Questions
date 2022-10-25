package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    static boolean isValid(int x, int y, int row, int col) {

        if(x<0 || y<0 || x>=row || y>=col) {
            return false;
        }

        return true;
    }

    private static void exploreOcean(boolean[][] ocean, int[][] heights, int i, int j) {


        if(isValid(i+1,j,heights.length,heights[0].length) && ocean[i+1][j] == false && heights[i+1][j]>=heights[i][j]) {
            ocean[i+1][j]=true;
            exploreOcean(ocean,heights,i+1,j);
        }

        if(isValid(i-1,j,heights.length,heights[0].length) && ocean[i-1][j] == false && heights[i-1][j]>=heights[i][j]) {
            ocean[i-1][j]=true;
            exploreOcean(ocean,heights,i-1,j);
        }

        if(isValid(i,j+1,heights.length,heights[0].length) && ocean[i][j+1] == false && heights[i][j+1]>=heights[i][j]) {
            ocean[i][j+1]=true;
            exploreOcean(ocean,heights,i,j+1);
        }

        if(isValid(i,j-1,heights.length,heights[0].length) && ocean[i][j-1] == false && heights[i][j-1]>=heights[i][j]) {
            ocean[i][j-1]=true;
            exploreOcean(ocean,heights,i,j-1);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0)
            return res;

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++){
            pacific[i][0] = true;
            atlantic[i][heights[0].length-1] = true;
        }
        for (int j = 0; j < heights[0].length; j++){
            pacific[0][j] = true;
            atlantic[heights.length-1][j] = true;
        }

        for(int i=0;i<heights.length;i++) {
            exploreOcean(pacific,heights,i,0);
            exploreOcean(atlantic,heights,i,heights[0].length-1);
        }

        for(int i=0;i<heights[0].length;i++) {
            exploreOcean(pacific,heights,0,i);
            exploreOcean(atlantic,heights,heights.length-1,i);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,2,3,5},
                {3,2,3,4,4}};
        List<List<Integer>> ans = pacificAtlantic(matrix);


    }
}

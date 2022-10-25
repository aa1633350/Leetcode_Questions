package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class SortMatrixDiagonally {

    static class Position {
        int i;
        int j;

        Position(int i, int j) {
            this.i=i;
            this.j=j;
        }
    }
    public static int[][] diagonalSort(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        Map<Integer, PriorityQueue<Integer>> diag = new HashMap<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                diag.putIfAbsent(i-j, new PriorityQueue<>());
                diag.get(i-j).add(matrix[i][j]);
            }
        }



        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                matrix[i][j]= diag.get(i-j).poll();
            }
        }

        for (int i=0;i<row;i++) {
            for(int j=0;j<col;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        return null;
    }

    public static void main(String[] args) {
        //int matrix[][] = {{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}};
        int matrix[][] = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        diagonalSort(matrix);
    }
}

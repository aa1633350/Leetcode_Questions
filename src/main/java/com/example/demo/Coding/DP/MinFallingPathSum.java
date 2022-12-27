package com.example.demo.Coding.DP;

public class MinFallingPathSum {

    public static int minFallingPathSum(int[][] matrix) {

        int cols = matrix[0].length;
        int [] dp = new int [cols];


        for(int i=0;i<dp.length;i++) {
            dp[i] = matrix[0][i];
        }

        int minSum = Integer.MAX_VALUE;
        for(int row=1;row<matrix.length;row++) {

            for(int col=0;col<cols;col++) {
                if(col==0) {
                    dp[col] = matrix[row][col] + Math.min(dp[col], dp[col+1]);
                } else if(col==cols-1) {
                    dp[col] = matrix[row][col] + Math.min(dp[col], dp[col-1]);
                } else {
                    dp[col] = matrix[row][col] + Math.min(Math.min(dp[col], dp[col-1]), dp[col+1]);
                }


                System.out.print(dp[col] + " ");
            }
            System.out.println();

        }
        return minSum;
    }

    public static void main(String[] args) {
        int matrix[][] = {{100,-42,-46,-41},{31,97,10,-10},{-58,-51,82,89},{51,81,69,-51}};
        minFallingPathSum(matrix);
    }
}

package com.example.demo.Coding.GeneralCode;

public class TransposeMatrix {


    public static void rotate(int[][] matrix) {

        // Transpose the matrix

        for(int i=0;i<matrix.length;i++) {
            for(int j=i;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int [] i : matrix) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int matrix[][] = {{3,3,1,1},
                          {2,2,1,2},
                          {1,1,1,2},
                          {0,0,0,0}};
        rotate(matrix);
    }
}

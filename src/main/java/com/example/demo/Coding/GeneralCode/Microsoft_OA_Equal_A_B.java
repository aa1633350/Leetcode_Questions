package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class Microsoft_OA_Equal_A_B {

    public static int solution(String[] board) {
        int R = board.length;
        int C = board[0].length();
        int result = 0;

        // Iterate through all possible rectangles starting from (0, 0)
        for (int endRow = 0; endRow < R; endRow++) {
            for (int endCol = 0; endCol < C; endCol++) {
                int countA = 0;
                int countB = 0;

                // Calculate the number of 'A' and 'B' in the current rectangle
                for (int row = 0; row <= endRow; row++) {
                    for (int col = 0; col <= endCol; col++) {
                        if (board[row].charAt(col) == 'A') {
                            countA++;
                        } else if (board[row].charAt(col) == 'B') {
                            countB++;
                        }
                    }
                }

                // Check if the number of 'A' and 'B' are equal
                if (countA == countB) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'A', 'B', '.', 'A'},
//                {'B', 'A', 'A', '.'},
//                {'.', 'B', 'A', 'B'},
//                {'A', '.', 'B', 'A'}
//        };

        char[][] grid = {
                {'A', 'B', '.'},
                {'B', '.', '.'},
                {'.', '.', 'A'}
        };

        // Test case 1
        String[] board1 = {"AB.", "B..", "..A"};
        System.out.println(solution(board1)); // Should return 5

        // Test case 2
        String[] board2 = {"A.", "AB"};
        System.out.println(solution(board2)); // Should return 0

        // Test case 3
        String[] board3 = {"..A", "A.."};
        System.out.println(solution(board3)); // Should return 9

        //System.out.println(countEqualABRectangles(grid));
    }
}

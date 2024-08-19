package com.example.demo.Coding.GeneralCode;


import java.util.LinkedList;
import java.util.Queue;

class MazeSolver {
    private static class Cell {
        int row, col, dist;
        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int minMoves(int[][] maze, int k) {
        int n = maze.length;
        int m = maze[0].length;

        if (maze[0][0] == 1 || maze[n-1][m-1] == 1) {
            return -1;  // Start or end is blocked
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0, 0));
        visited[0][0] = true;

        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // If we reached the end
            if (current.row == n - 1 && current.col == m - 1) {
                return current.dist;
            }

            // Try all four directions
            for (int i = 0; i < 4; i++) {
                for (int jump = 1; jump <= k; jump++) {
                    int newRow = current.row + jump * dRow[i];
                    int newCol = current.col + jump * dCol[i];

                    // Check boundaries
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (maze[newRow][newCol] == 1) {
                            break;  // Encountered obstacle
                        }
                        if (!visited[newRow][newCol]) {
                            visited[newRow][newCol] = true;
                            queue.add(new Cell(newRow, newCol, current.dist + 1));
                        }
                    }
                }
            }
        }

        return -1;  // If no path found
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };
        int k = 2;
        System.out.println(minMoves(maze, k));  // Output the result
    }
}


package com.example.demo.Coding.Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        String [] names = new String[5];
        boolean[][] visited = new boolean[rows][cols];

        // Step 1: Find the first island and mark all cells of the island as visited
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    markFirstIsland(grid, i, j, queue, visited);
                    found = true;
                    break;
                }
            }
        }

        // Step 2: Perform BFS from the first island to find the shortest distance to the second island
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 1) {
                            return distance;
                        }
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            distance++;
        }

        return -1; // No bridge found
    }

    private void markFirstIsland(int[][] grid, int row, int col, Queue<int[]> queue, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        markFirstIsland(grid, row - 1, col, queue, visited);
        markFirstIsland(grid, row + 1, col, queue, visited);
        markFirstIsland(grid, row, col - 1, queue, visited);
        markFirstIsland(grid, row, col + 1, queue, visited);
    }
}

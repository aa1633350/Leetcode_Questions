package com.example.demo.Coding.Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class MineSwepper {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

    class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private boolean isLegal(int newR, int newC, int r, int c) {
        if (newR >= 0 && newR < r && newC >= 0 && newC < c) {
            return true;
        }

        return false;
    }

    private char[][] bfs(char[][] board, int startRow, int startCol, boolean[][] visited) {
        int r = board.length, c = board[0].length;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startRow, startCol));

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                Node node = q.poll();
                int row = node.r;
                int col = node.c;
                if (visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                int mine = 0;
                for (int i = 0; i < 8; i++) {
                    int newR = row + dirs[i][0];
                    int newC = col + dirs[i][1];

                    if (isLegal(newR, newC, r, c)) {
                        if (board[newR][newC] == 'M') {
                            mine++;
                        } else {
                            q.add(new Node(newR, newC));
                        }

                    }
                }
                if (mine == 0) {
                    board[row][col] = 'B';
                } else {
                    board[row][col] = (char) (mine + '0');
                }
            }
        }
        return board;
    }

    public char[][] updateBoard(char[][] board, int[] click) {

        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        int startRow = click[0], startCol = click[1];
        if (board[startRow][startCol] == 'M') {
            board[startRow][startCol] = 'X';
            return board;
        }
        return bfs(board, startRow, startCol, visited);
    }

    public static void main(String[] args) {
        char [][] board = {{'E','E','E','E','E'},
                            {'E','E','M','E','E'},
                            {'E','E','E','E','E'},
                            {'E','E','E','E','E'}};

        int [] click = {3,0};
        MineSwepper mineSwepper = new MineSwepper();
        mineSwepper.updateBoard(board,click);
    }
}

package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
        private boolean isLegal(int r, int c, int row, int col, boolean [][] visited) {
            // if(r>0 && c>0 && r<row && c<col && !visited[r][c]) {
            //     return true;
            // }
            if(r>0 && c>0 && r<row && c<col) {
                return true;
            }
            return false;
        }
        private boolean dfs(int r, int c, String s, char[][] board, boolean [][] visited, String str, int idx) {

            if(!isLegal(r,c,board.length,board[0].length, visited) || visited[r][c]) {
                return false;
            }
            if(str.equals(s)) {
                return true;
            }
            if(board[r][c] == s.charAt(idx)) {
                str+=Character.toString(board[r][c]);
                idx++;
            } else {
                return false;
            }
            visited[r][c] = true;
            boolean down = dfs(r+1,c,s,board,visited,str,idx);
            boolean right = dfs(r,c+1,s,board,visited,str,idx);
            boolean up = dfs(r-1,c,s,board,visited,str,idx);
            boolean left = dfs(r,c-1,s,board,visited,str,idx);
            return down || right || up || left;

        }

        public List<String> findWords(char[][] board, String[] words) {

            int row = board.length, col = board[0].length;
            List<String> ans = new ArrayList<>();
            for(String s : words) {
                char firstChar = s.charAt(0);
                boolean found = false;
                for(int i=0;i<row;i++) {
                    for(int j=0;j<col;j++) {
                        if(board[i][j] == firstChar) {
                            boolean [][] visited = new boolean[row][col];
                            found = dfs(i,j,s,board,visited,"",0);
                            if(found) {
                                ans.add(s);
                                break;
                            }
                        }
                    }
                    if(found) {
                        break;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String [] word = {"oath","pea","eat","rain"};
        WordSearch2 wordSearch2 = new WordSearch2();
        wordSearch2.findWords(board,word);
    }
}

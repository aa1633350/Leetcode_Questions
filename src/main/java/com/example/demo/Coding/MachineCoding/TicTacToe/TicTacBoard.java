package com.example.demo.Coding.MachineCoding.TicTacToe;

public class TicTacBoard {

    String [][] board = new String[3][3];
    static TicTacBoard instance;
    public String[][] getBoard() {
        return board;
    }

    public void setBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                board[i][j]="-";
            }
        }
    }

    public void printBoard() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static TicTacBoard getInstance() {
        if(instance == null) {
            instance = new TicTacBoard();
        }
        return instance;
    }
}

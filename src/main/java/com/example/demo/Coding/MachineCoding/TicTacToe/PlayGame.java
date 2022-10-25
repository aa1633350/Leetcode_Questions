package com.example.demo.Coding.MachineCoding.TicTacToe;

import java.util.Objects;
import java.util.Scanner;

public class PlayGame {

    String [][] board;
    boolean winner = false;
    String player;
    int row;
    int col;
    Players players = Players.getInstance();
    TicTacBoard ticTacBoard;
    public PlayGame(TicTacBoard ticTacBoard) {
        this.board = ticTacBoard.getBoard();
        this.ticTacBoard = ticTacBoard;
    }

    public void startGame() {
        int noOfTurnsPlayerOne = 0;
        int noOfTurnsPlayerTwo = 0;
        boolean playerOneChance = true;
        boolean playerTwoChance = false;
        Scanner sc = new Scanner(System.in);
        while(!winner) {

            if(playerOneChance) {
                player = players.getPlayerOne();
                noOfTurnsPlayerOne++;
            } else {
                player = players.getPlayerTwo();
                noOfTurnsPlayerTwo++;
            }
            System.out.println("Player " + player + " enter the row amd col to make a move");

            row = sc.nextInt();
            col = sc.nextInt();

            if(inBounds(row,col) && Objects.equals(board[row][col], "-") && playerOneChance) {
                board[row][col]="X";
                playerOneChance = false;
                playerTwoChance = true;
            }
            else if(inBounds(row,col) && board[row][col].equals("-") && playerTwoChance) {
                board[row][col]="O";
                playerOneChance = true;
                playerTwoChance = false;
            }
            ticTacBoard.printBoard();


            if(noOfTurnsPlayerOne >= 4 || noOfTurnsPlayerTwo >= 4) {
                int win = checkWinner(board);

                if(win==1) {
                    System.out.println("Player 1 wins !!");
                } else if(win==2) {
                    System.out.println("Player 1 wins !!");
                } else {
                    System.out.println("Draw !!");
                }

                winner = true;
            }

        }
    }

    boolean inBounds(int row,int col) {
        if(row>=0 && row<3 && col>=0 && col<3) {
            return true;
        }
        return false;
    }
    // check diagonally , horizontal and vertical
    int checkWinner(String [][] board) {
        // check horizontally each col
        for(int i=0;i<3;i++) {
            int countX=0;
            int countO=0;
            for(int j=0; j<3; j++) {
                if(board[i][j].equals("X")) {
                    countX++;
                } else if(board[i][j].equals("O")) {
                    countO++;
                }
            }
            if(countX==3) {
                return 1;
            } else if(countO==3) {
                return 2;
            }
            // check vertically
            countX=0;
            countO=0;
            for(int j=0; j<3; j++) {
                if(board[j][i].equals("X")) {
                    countX++;
                } else if(board[j][i].equals("O")) {
                    countO++;
                }
            }
            if(countX==3) {
                return 1;
            } else if(countO==3) {
                return 2;
            }

            // check diagonally
            countX=0;
            countO=0;
            for(int j=0; j<3; j++) {
                if(board[j][j].equals("X")) {
                    countX++;
                } else if(board[j][j].equals("O")) {
                    countO++;
                }
            }
            if(countX==3) {
                return 1;
            } else if(countO==3) {
                return 2;
            }

            // check opposite diagonally
            countX=0;
            countO=0;
            for(int j=2; j>=0; j--) {
                if(board[j][j].equals("X")) {
                    countX++;
                } else if(board[j][j].equals("O")) {
                    countO++;
                }
            }
            if(countX==3) {
                return 1;
            } else if(countO==3) {
                return 2;
            }
        }
        return 0;
    }

}

package com.example.demo.Coding.MachineCoding.TicTacToe;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Players players = Players.getInstance();
        System.out.println("Input the player names");
        Scanner sc = new Scanner(System.in);
        players.setPlayerOne(sc.next());
        players.setPlayerTwo(sc.next());
        TicTacBoard ticTacBoard = TicTacBoard.getInstance();
        ticTacBoard.setBoard();
        System.out.println("Initial Board !!");
        ticTacBoard.printBoard();

        PlayGame playGame = new PlayGame(ticTacBoard);
        playGame.startGame();
    }
}

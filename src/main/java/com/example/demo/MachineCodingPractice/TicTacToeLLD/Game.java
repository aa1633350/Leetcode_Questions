package com.example.demo.MachineCodingPractice.TicTacToeLLD;

// This is the driver class.
public class Game {
    public static void main(String[] args) {
        Board board = new Board(3);
        System.out.println(board.startGame());
    }
}

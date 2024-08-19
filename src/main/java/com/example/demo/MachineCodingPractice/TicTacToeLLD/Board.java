package com.example.demo.MachineCodingPractice.TicTacToeLLD;

import java.util.Deque;

public class Board {
    int size;
    //Board is an n*n matrix of Playing Piece.
    PlayingPiece [][] board;
    Deque<Player> players;
    Board (int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
        initialize();

    }

    private void initialize() {
        PieceX pieceX = new PieceX();
        Player playerX = new Player("Aditya", pieceX);
        PieceO pieceO = new PieceO();
        Player playerO = new Player("Saurabh", pieceO);
        players.add(playerX);
        players.add(playerO);

    }

    /**
     *
     * @return Returns the name of Player that won the game
     */
    public String startGame() {
        return "winner";
    }
}

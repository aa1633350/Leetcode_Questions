package com.example.demo.Coding.MachineCoding.TicTacToe;

public class Players {

    String playerOne;
    String playerTwo;
    static Players instance;

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public static Players getInstance() {
        if(instance == null) {
            instance = new Players();
        }
        return instance;
    }
}

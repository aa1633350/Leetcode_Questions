package com.example.demo.Coding.MachineCoding.SnakeAndLadderGame;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private int [][] gameBoard = new int [10][10];
    Map<Integer,Integer> ladderMap = new HashMap<>();
    Map<Integer,Integer> snakesMap = new HashMap<>();
    public void setBoard(int [][] headAndTail, int [][] ladderStartEnd) {
        int numbers=0;
        for (int row=0; row<gameBoard.length; row++) {
            for (int col=0;col<gameBoard[0].length;col++) {
                gameBoard[row][col]=numbers++;
            }
        }

        for (int ladder=0;ladder<ladderStartEnd.length;ladder++) {
            int startPosLadder = ladderStartEnd[ladder][0];
            int endPosLadder = ladderStartEnd[ladder][1];
            ladderMap.put(startPosLadder,endPosLadder);
        }

        for (int snake=0; snake<headAndTail.length; snake++) {
            int startPosSnake = headAndTail[snake][0];
            int endPosSnake = headAndTail[snake][1];
            snakesMap.put(startPosSnake,endPosSnake);
        }


    }

    public void play(String [] players) {
        boolean winnerFound = false;
        String winner = "";

        int [] playerPositions = new int [100];
        System.out.println("Let's play !!!!");
        Dice roll = new Dice();
        while(!winnerFound) {
            int playerChance = 1;
            for(String player : players) {
                System.out.println("Player " + player + " roll the dice");
                int move = roll.rollDice();
                int initialPosition = playerPositions[playerChance-1];
                playerPositions[playerChance-1] = (playerPositions[playerChance-1] + move);
                int currPlayerPosition = playerPositions[playerChance-1];
                if(currPlayerPosition > 100) {
                    continue;
                }
                if (ladderMap.containsKey(currPlayerPosition)) {
                    currPlayerPosition = ladderMap.get(currPlayerPosition);
                }

                if (snakesMap.containsKey(currPlayerPosition)) {
                    currPlayerPosition = snakesMap.get(currPlayerPosition);
                }
                playerPositions[playerChance-1] = currPlayerPosition;
                System.out.println(player + " rolled a " + move + " and moved from " + initialPosition
                + " to " + currPlayerPosition);
                if(currPlayerPosition == 100) {
                    winner = player;
                    winnerFound=true;
                }

                if(winnerFound) {
                    break;
                }
                playerChance++;
            }
        }
        System.out.println("Congratulations " + winner + "won the game");
    }

    private int getRow(int pos) {
        if(pos<=10) {
            return 0;
        } else if(pos<=20) {
            return 1;
        } else if(pos<=30) {
            return 2;
        } else if(pos<=40) {
            return 3;
        } else if(pos<=50) {
            return 4;
        } else if(pos<=60) {
            return 5;
        } else if(pos<=70) {
            return 6;
        } else if(pos<=80) {
            return 7;
        } else if(pos<=90) {
            return 8;
        } else  {
            return 9;
        }

    }
}

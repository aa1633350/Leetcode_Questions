package com.example.demo.Coding.MachineCoding.SnakeAndLadderGame;

import java.util.Scanner;

public class SnakeAndLadder {

    private static int numberOfSnakes;
    private static int numberOfPlayers;
    private static int numberOfLadders;
    private static int [][] headAndTail;
    private static int [][] ladderStartEnd;
    private static String [] players;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of snakes");
        numberOfSnakes = sc.nextInt();
        headAndTail = new int [numberOfSnakes][2];
        for(int snake=0;snake<numberOfSnakes;snake++) {
            System.out.println("Please input the head and tail of snake");
            headAndTail[snake][0] = sc.nextInt();
            headAndTail[snake][1] = sc.nextInt();
        }

        System.out.println("Please input the number of ladders");
        numberOfLadders = sc.nextInt();
        ladderStartEnd = new int [numberOfLadders][2];
        for(int i=0;i<numberOfLadders;i++) {
            System.out.println("Please input start and end of Ladder");
            ladderStartEnd[i][0] = sc.nextInt();
            ladderStartEnd[i][1] = sc.nextInt();
        }
        System.out.println("Please input the number of players");
        numberOfPlayers = sc.nextInt();
        players = new String [numberOfPlayers];
        for(int player=0;player<numberOfPlayers;player++) {
            System.out.println("Please input player " + player + " name");
            players[player] = sc.next();
        }

        Board board = new Board();
        board.setBoard(headAndTail,ladderStartEnd);
        board.play(players);
    }
}

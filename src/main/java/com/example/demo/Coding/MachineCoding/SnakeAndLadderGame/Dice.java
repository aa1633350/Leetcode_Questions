package com.example.demo.Coding.MachineCoding.SnakeAndLadderGame;

import java.util.Random;

public class Dice {

    protected int rollDice() {

        Random randomRoll = new Random();
        return 1 + randomRoll.nextInt(5);
    }
}

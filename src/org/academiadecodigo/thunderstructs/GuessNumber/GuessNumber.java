package org.academiadecodigo.thunderstructs.GuessNumber;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;

public class GuessNumber {

    private int min = 0;
    private int max = 10;
    private int player1Choice;

    public Prompt prompt;

    int maxGuess;
    Player[] players;

    public GuessNumber(int maxGuess, Player[] players){

        this.maxGuess = maxGuess;
        this.players = players;

    }

    public void start(){

    }

    public void player1GuessNumber() {

        if()
    }

    public void player1Guess() {

        IntegerInputScanner question1 = new IntegerRangeInputScanner(min, max);
        player1Choice = prompt.getUserInput(question1);
    }



}

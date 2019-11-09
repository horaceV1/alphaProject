package org.academiadecodigo.thunderstructs.Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    private static Blackjack game;
    private ArrayList<Person> players;
    private Deck deck;

    public Blackjack() {
        initializeGame();
        dealCards();
        takeTurns();
        declareWinner();
        playAgain();
    }

    public static void main(String[] args) {
        game = new Blackjack();
    }

    private void initializeGame() {
        deck = new Deck();
        players = new ArrayList<Person>();
        players.add(new Player());
        players.add(new Dealer());

        System.out.println("Welcome to a new Blackjack game!");
    }

    private void dealCards() {
        for(Person player : players) {
            deck.dealInitialCards(player);
            player.printCards(player.getName().equals("You"));
        }
    }

    private void takeTurns() {
        for(Person player : players) {
            boolean endOfTurn = false;
            while(!endOfTurn) {
                player.printCards(true);
                boolean hit = player.wantToHit();
                if(hit) {
                    deck.dealCard(player);
                    System.out.println(player.getName() + " drew a card.\n");
                    if(player.getTotal() > 21) {
                        endOfTurn = true;
                        System.out.println(player.getName() + " died.\n");
                    }
                }else{
                    endOfTurn = true;
                    System.out.println(player.getName() + " stayed\n");
                }
            }
        }
    }

    private void declareWinner() {
        byte highest = -1;
        byte topPlayer = -1;
        for(byte i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();
            byte total = players.get(i).getTotal();

            System.out.println(name + (name.equals("You") ? " have " : " has ") + "a total of " + total + ".");

            if(total > highest && total <= 21) {
                highest = total;
                topPlayer = i;
            }
            if(total == highest && name.equals("The dealer")) {
                topPlayer = i;
            }
        }
        if(topPlayer == -1) {
            System.out.println("Everyone is dead. Nobody wins.");
        }else{
            System.out.println(players.get(topPlayer).getName() + " wins!");
        }
    }

    private void playAgain() {
        System.out.println("\nPlay again? \"y\" / \"n\": ");
        Scanner keyboard = new Scanner (System.in);
        while(true) {
            String input = keyboard.next();
            if(input.equals("y")) {
                game = new Blackjack();
            }else if(input.equals("n")) {
                System.exit(0);
            }else{
                System.out.println("Please type \"y\" or \"n\": ");
            }
        }
    }
}

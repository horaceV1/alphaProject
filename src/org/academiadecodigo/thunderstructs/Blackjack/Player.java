package org.academiadecodigo.thunderstructs.Blackjack;

import java.util.Scanner;

public class Player extends Person {
    private Scanner keyboard;

    public Player() {
        super();
        name = "You";
        keyboard = new Scanner(System.in);
    }

    public boolean wantToHit() {
        System.out.println("\nWould you like to \"hit\" or \"stay\": ");
        while(true) {
            String input = keyboard.next();
            if(input.equals("hit")) {
                return true;
            }else if(input.equals("stay")) {
                return false;
            }else{
                System.out.println("Type \"hit\" or \"stay\": ");
            }
        }
    }
}

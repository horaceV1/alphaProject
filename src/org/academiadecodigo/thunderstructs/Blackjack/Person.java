package org.academiadecodigo.thunderstructs.Blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private List<Card> cards;
    protected String name;
    protected byte total;

    public Person() {
        cards = new ArrayList<Card>();
        total = 0;
    }

    public String getName() {
        return name;
    }

    public Card receiveCard(Card card) {
        cards.add(card);
        total += card.getValue();
        return card;
    }

    public abstract boolean wantToHit();

    public byte getTotal() {
        return total;
    }

    public void printCards(boolean showAll) {
        System.out.println("\n" + name + (name == "You" ? " have a" : " has a") + (cards.get(0).getValue() == 8
                || cards.get(0).getValue() == 11 ? "n " : " ") + cards.get(0).toString());
        for(int i = 1; i < cards.size(); i++) {
            if(showAll) {
                System.out.println(" and a" + (cards.get(i).getValue() == 8
                        || cards.get(i).getValue() == 11 ? "n " : " ") + cards.get(i).toString());
            }else{
                System.out.println(" and a hidden card.");
            }
        }
        if(showAll) {
            System.out.println(".\n" + name + (name == "You" ? "r" : "'s") + " total is " + total + ".");
        }
    }
}

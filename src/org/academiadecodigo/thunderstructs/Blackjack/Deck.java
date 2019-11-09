package org.academiadecodigo.thunderstructs.Blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    public Card drawNextCard() {
        int value = ThreadLocalRandom.current().nextInt(2,12);
        return new Card(value);
    }

    public void dealCard(Person person) {
        person.receiveCard(drawNextCard());
    }

    public void dealInitialCards(Person person) {
        dealCard(person);
        dealCard(person);
    }
}

package org.academiadecodigo.thunderstructs.Blackjack;

import java.util.concurrent.ThreadLocalRandom;

public class Dealer extends Person {

    public Dealer() {
        super();
        name = "The dealer";
    }

    public boolean wantToHit() {
        if(total < 16) return true;
        if(total > 16) return false;
        if(ThreadLocalRandom.current().nextInt(0,2) == 0) return true;
        return false;
    }
}

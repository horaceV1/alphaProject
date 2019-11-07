package org.academiadecodigo.thunderstructs.GuessNumber;

public class Play {

    public static void main(String[] args) {

        Player[] players = new Player[] {
                new Player("Fabia"),
                new Player("José"),
                new Player("Vasco"),
                new Player("Daniel")
        };

        GuessNumber guessNumber = new GuessNumber(5, players);
        guessNumber.start();

    }
}

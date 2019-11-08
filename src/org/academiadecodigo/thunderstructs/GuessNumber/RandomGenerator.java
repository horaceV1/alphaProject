package org.academiadecodigo.thunderstructs.GuessNumber;

public class RandomGenerator {

    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

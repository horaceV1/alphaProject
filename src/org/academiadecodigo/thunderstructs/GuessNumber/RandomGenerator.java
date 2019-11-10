package org.academiadecodigo.thunderstructs.GuessNumber;

public class RandomGenerator {

<<<<<<< HEAD
    public static int generateNumber(){
        return (int)(Math.random() * 10);
    }

=======
    public static int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
>>>>>>> guessnumber
}

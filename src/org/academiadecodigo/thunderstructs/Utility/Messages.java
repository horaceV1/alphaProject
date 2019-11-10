package org.academiadecodigo.thunderstructs.Utility;

public class Messages {

    public final static String WELCOME_TEXT = Colors.TEXT_BLUE +
                                 "|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|\\|\n" + Colors.ANSI_RESET +
           Colors.TEXT_BLUE +    "|\\|"+Colors.ANSI_RESET + Colors.BOLD + "      ____                          " + Colors.BACKGROUND_ORANGE +"   _   _       _         " + Colors.ANSI_RESET + Colors.TEXT_BLUE + "|/|" +
           Colors.TEXT_BLUE +    "\n|/| "+Colors.ANSI_RESET + Colors.BOLD + "    / ___| __ _ _ __ ___   ___     " + Colors.BACKGROUND_ORANGE +"  | | | |_   _| |__      " + Colors.ANSI_RESET + Colors.TEXT_BLUE + "|\\|"+
           Colors.TEXT_BLUE +    "\n|\\|"+Colors.ANSI_RESET + Colors.BOLD + "    | |  _ / _` | '_ ` _ \\ / _ \\    "+ Colors.BACKGROUND_ORANGE +"  | |_| | | | | '_ \\     "+ Colors.ANSI_RESET + Colors.TEXT_BLUE + "|/|" +
           Colors.TEXT_BLUE +    "\n|/| "+Colors.ANSI_RESET + Colors.BOLD + "   | |_| | (_| | | | | | |  __/    "+ Colors.BACKGROUND_ORANGE +"  |  _  | |_| | |_) |    "+ Colors.ANSI_RESET + Colors.TEXT_BLUE + "|\\|"+
           Colors.TEXT_BLUE +    "\n|\\|"+Colors.ANSI_RESET + Colors.BOLD + "     \\____|\\__,_|_| |_| |_|\\___|    "+ Colors.BACKGROUND_ORANGE +"  |_| |_|\\__,_|_.__/     "+ Colors.ANSI_RESET + Colors.TEXT_BLUE + "|/|" +
           Colors.TEXT_BLUE +    "\n|/| "+Colors.ANSI_RESET + Colors.BOLD + "                                   " + Colors.BACKGROUND_ORANGE +"                         "+ Colors.ANSI_RESET + Colors.TEXT_BLUE + "|\\|"+
            "\n|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/|\\|/| \n" + Colors.ANSI_RESET;

    public final static String INSTRUCTIONS =
            "In this classic pick a number game, the system will choose a random " +
            "from a certain range.\nYou will have to input a number and try to guess which number the system choose" +
             Colors.BOLD +"\nPress any key to go back" + Colors.ANSI_RESET;

<<<<<<< HEAD
=======
    public final static String INSTRUCTIONS =
            "1: For the Guess a Number, the server will choose a number from 1 to 10, " +
            "the players will try to guess the number, the game will repeat until someone guesses the number." +
            "\n2: For the Card Pick, the server will generate a random card from a full deck, the players will try to guess the card " +
            "and the game will repeat until someone wins." +
            "\n3: For the BlackJack, the server will be giving cards, you can press Hit to get a new card or Stay to stop drawing cards, " +
            "the first player to get closer to 21 points wins." +
            "\nPress any key to go back";

>>>>>>> a704ca3ca4410c9e9a81b49217a958c8b16aa7ed
    public final static String GUESSNUMBER_OPEN = "Opened Guess the Number game";
    public final static String GUESSCARD_OPEN = "Opened Guess the Card game";
    public final static String BLACKJACK_OPEN = "Opened Blackjack";

}

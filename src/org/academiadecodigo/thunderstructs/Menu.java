package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Blackjack.Blackjack;
import org.academiadecodigo.thunderstructs.Utility.Messages;

public class Menu {

    private Prompt prompt;

    public void run() {

        String[] options = {"Instructions", "Guess the Number", "Guess the Card", "BlackJack", "Quit"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions(menuAnswer);

    }

    public void menuOptions(int menuAnswer) {

        switch (menuAnswer) {
            case 1:
                instructions();
                break;
            case 2:
                System.out.println("Guess the Number!");
                break;
            case 3:
                System.out.println("Guess the Card!");
                break;
            case 4:
                System.out.println("BlackJack!");
                Blackjack blackjack = new Blackjack();
                blackjack.run();
                break;
            case 5:
                System.out.println("Bye!");
                System.exit(0);
                break;
        }
    }

    private void instructions() {
        StringInputScanner goBack = new StringInputScanner();
        goBack.setMessage(Messages.INSTRUCTIONS);
        prompt.getUserInput(goBack);
        run();
    }

}

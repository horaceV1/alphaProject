package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
<<<<<<< HEAD
import org.academiadecodigo.thunderstructs.Utility.Colors;
=======
<<<<<<< HEAD
>>>>>>> a704ca3ca4410c9e9a81b49217a958c8b16aa7ed
import org.academiadecodigo.thunderstructs.Utility.Messages;

import static org.academiadecodigo.thunderstructs.Utility.Messages.INSTRUCTIONS;

=======
import org.academiadecodigo.thunderstructs.Blackjack.Blackjack;
import org.academiadecodigo.thunderstructs.Utility.Messages;

>>>>>>> guessnumber
public class Menu {

    private Prompt prompt;

    public void run() {

        prompt = new Prompt(System.in, System.out);

<<<<<<< HEAD
        String[] options = {Colors.BOLD +"Instructions", "Number Picker", "Quit" + Colors.ANSI_RESET};
=======
        String[] options = {"Instructions", "Guess the Number", "Guess the Card", "BlackJack", "Quit"};
>>>>>>> a704ca3ca4410c9e9a81b49217a958c8b16aa7ed

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

<<<<<<< HEAD
    public void instructions() {
=======
    private void instructions() {
>>>>>>> guessnumber
        StringInputScanner goBack = new StringInputScanner();
        goBack.setMessage(Messages.INSTRUCTIONS);
        prompt.getUserInput(goBack);
        run();
    }

}

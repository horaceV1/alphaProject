package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Utility.Colors;
import org.academiadecodigo.thunderstructs.Utility.Messages;

import static org.academiadecodigo.thunderstructs.Utility.Messages.INSTRUCTIONS;

public class Menu {

    public Prompt prompt;

    public void run() {

        prompt = new Prompt(System.in, System.out);

        String[] options = {Colors.BOLD +"Instructions", "Number Picker", "Quit" + Colors.ANSI_RESET};

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
                System.out.println("Bye!");
                System.exit(0);
                break;
        }
    }

    public void instructions() {
        StringInputScanner goBack = new StringInputScanner();
        goBack.setMessage(Messages.INSTRUCTIONS);
        prompt.getUserInput(goBack);
        run();
    }

}

package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Menu {

    public Prompt prompt;

    public void run(){

        prompt = new Prompt(System.in, System.out);

        String[] options = {"Instructions", "Number Picker", "Quit"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions(menuAnswer);

    }

    public void menuOptions(int menuAnswer) {

        //while (true) {

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
           // break;
        //}
    }

    public void instructions(){
        StringInputScanner goBack = new StringInputScanner();
        goBack.setMessage(Messages.INSTRUCTIONS);
        prompt.getUserInput(goBack);
        run();
    }

}

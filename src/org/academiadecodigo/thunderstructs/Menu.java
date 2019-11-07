package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public void run(){

        Prompt prompt = new Prompt(System.in, System.out);

        String[] options = {"Instructions", "Number Picker", "Quit"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions(menuAnswer - 1);

    }

    public void menuOptions(int menuAnswer) {

        while (true) {

            switch (menuAnswer) {

                case 1:
                    System.out.println("Instructions chosen");
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("Guess the Number chosen");
                    System.exit(0);
                    break;
                case 3:
                    System.out.println("Quit");
                    System.exit(0);
                    break;
            }
            break;
        }
    }

}

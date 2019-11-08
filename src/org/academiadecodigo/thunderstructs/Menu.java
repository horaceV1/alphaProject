package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import static org.academiadecodigo.thunderstructs.Messages.INSTRUCTIONS;

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
                    //Escolher um input para poder voltar para trás sem lixar o menu
                    //Simplesmente faz um prompt com as instruções do jogo
                    System.out.println(INSTRUCTIONS);
                    System.exit(0);
                    break;
                case 2:
                    System.out.println("Guess the Number!");

                    break;
                case 3:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
            }
            break;
        }
    }

}

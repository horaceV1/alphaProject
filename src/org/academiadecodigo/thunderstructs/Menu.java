package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public void menu(){
        Prompt prompt = new Prompt(System.in, System.out);

        String[] options = {"Instructions", "Number Picker", "Quit"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Menu");
        int menuAnswer = prompt.getUserInput(menu);
    }
}

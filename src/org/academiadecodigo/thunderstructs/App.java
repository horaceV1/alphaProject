package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.Utility.Messages;

import static org.academiadecodigo.thunderstructs.Utility.Messages.WELCOME_TEXT;

public class App {


    public static void main(String[] args) {

        System.out.print(Messages.WELCOME_TEXT);
        Menu menu = new Menu();
        menu.run();

    }

}

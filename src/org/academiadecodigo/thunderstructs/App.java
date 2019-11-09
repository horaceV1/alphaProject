package org.academiadecodigo.thunderstructs;

import org.academiadecodigo.thunderstructs.Utility.Messages;

public class App {


    public static void main(String[] args) {

        System.out.println(Messages.WELCOME_TEXT);

        Menu menu = new Menu();
        menu.run();

    }

}

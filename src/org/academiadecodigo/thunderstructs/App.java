package org.academiadecodigo.thunderstructs;

import static org.academiadecodigo.thunderstructs.Messages.WELCOME_TEXT;

public class App {


    public static void main(String[] args) {

        System.out.println(WELCOME_TEXT);

        Menu menu = new Menu();
        menu.run();

    }

}

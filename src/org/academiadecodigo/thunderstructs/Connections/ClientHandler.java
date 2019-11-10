package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
<<<<<<< HEAD
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
=======
>>>>>>> guessnumber
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Blackjack.Blackjack;
import org.academiadecodigo.thunderstructs.Menu;
import org.academiadecodigo.thunderstructs.Utility.Colors;
import org.academiadecodigo.thunderstructs.Utility.Messages;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    public PrintStream sendToClient;
    public Menu menu = new Menu();
    boolean gameOver = false;
    private Socket clientSocket;
    private Server server;
    private DataInputStream clientInputStream;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
    private String nickname = "";
>>>>>>> guessnumber
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
    private Prompt prompt;
    private String nickname = "";
    private int playerChoice;
<<<<<<< HEAD
    private boolean openMenu = true;
=======
    public Menu menu = new Menu();


    private int min = 0;
    private int max = 10;
    private int player1Choice;

    private int systemNumber;

>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9

    public ClientHandler(Socket clientSocket, Server server) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            if(!gameOver){
            clientInputStream = new DataInputStream(clientSocket.getInputStream());
            sendToClient = new PrintStream(clientSocket.getOutputStream());
            prompt = new Prompt(clientInputStream, sendToClient);
            runMenu();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runMenu() {

<<<<<<< HEAD
        String[] options = {"Instructions", "Guess the Number", "Quit"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions2(menuAnswer);
=======
        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Introduce yourself: ");
        String message = prompt.getUserInput(stringInputScanner);
        //this.nickname = message;

        registerClient(message, this);
        broadcast(message + " has joined the lobby.");
    }
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9

    }

    public void pickName() {

<<<<<<< HEAD
        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Introduce yourself: ");
        String name = prompt.getUserInput(stringInputScanner);

        registerClient(name, this);
        broadcast(name + " has joined the lobby.");

        if (Server.hashMap.size() == 0) {
            System.out.println("Server number: " + server.getSystemNumber());
        }
=======
        System.out.println("System number: " + randomNumber(0, 10));

        for (String client : Server.hashMap.keySet()) {

<<<<<<< HEAD
        registerClient(message, this);
        System.out.println("Server number: " + server.getSystemNumber());
        broadcast(message + " has joined the lobby.");
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
    }

    public void broadcast(String message) {

        for (String client : Server.hashMap.keySet()) {
            if(!gameOver && !openMenu) {
                System.out.println(client + ": " + message);
                Server.hashMap.get(client).sendToClient.println(message);
                System.out.println(Server.hashMap.get(client).getNickname());
            } else if (gameOver && !openMenu){
                subMenu();
            } else if (openMenu && gameOver) {
                runMenu();
            }

            while (!gameOver) {
                openMenu = false;
                gameLogic(client);
            }
        }

    }

    public void gameLogic(String client) {

        if (Server.hashMap.size() <= 1) {
            return;
        }

        if(server.getCounter() == 0) {
            IntegerInputScanner question1 = new IntegerRangeInputScanner(server.getMin(), server.getMax());
            question1.setMessage("Pick a number: ");
            playerChoice = prompt.getUserInput(question1);
            System.out.println(client + ": " + playerChoice);
            Server.counter += 1;
            System.out.println(Server.counter);
            if(Server.counter == Server.hashMap.size()) {
                server.resetCounter();
            }
        }

        if (playerChoice == server.getSystemNumber()) {
            gameOver = true;
            broadcast(client + " won!");
            Server.hashMap.clear();
            subMenu();
        }
    }

<<<<<<< HEAD
    public void subMenu() {
=======
    public void endgameMenu() {
=======
            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);
>>>>>>> guessnumber
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9

        String[] options = {"Back to Menu", "Quit"};

<<<<<<< HEAD
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Choose an option: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        if(menuAnswer == 1) {
            menuOptions(1);
        }else{
          menuOptions(2);
            }
        }

    public void menuOptions(int menuAnswer) {
        switch (menuAnswer) {
            case 1:
                openMenu = true;
                broadcast("Opening menu");

            case 2:
               System.exit(1);
                break;
        }
    }
///////////////////////////////////////////////////////////////////////////////
    public void menuOptions2(int menuAnswer2) {

        switch (menuAnswer2) {
            case 1:
                instructions();
                break;
            case 2:
                System.out.println("Guess the Number");
                openMenu = false;
                gameOver = false;
                pickName();
                break;
            case 3:
                System.out.println("Bye!");
                System.exit(0);
                break;
        }
    }

<<<<<<< HEAD
    private void instructions() {
        StringInputScanner goBack = new StringInputScanner();
        goBack.setMessage(Messages.INSTRUCTIONS);
        goBack.setError("Press ANY key and ENTER to go back!");
        prompt.getUserInput(goBack);
        run();
=======
    public String getNickname () {
=======
            while (true) {

                IntegerInputScanner question1 = new IntegerRangeInputScanner(min, max);
                question1.setMessage("Pick a number: ");
                player1Choice = prompt.getUserInput(question1);
                System.out.println(client + ": " + player1Choice);

                if(player1Choice == systemNumber) {
                    System.out.println(client + ", you won!");
                }

                //metes um mathrandom numa variavel, IF um client acertar acaba o jogo
            }
        }
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
    }

    public String getNickname() {
>>>>>>> guessnumber
        return this.nickname;
    }

<<<<<<< HEAD
    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }
=======
    public int randomNumber(int min, int max) {

        // Between 0+min and (max-min+min)
        systemNumber = (int) (Math.random() * (max - min + 1) + min);

        return systemNumber;

    }

>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
}

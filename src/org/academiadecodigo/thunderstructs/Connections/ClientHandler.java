package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
<<<<<<< HEAD
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
=======
>>>>>>> guessnumber
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Menu;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    public PrintStream sendToClient;
    private Socket clientSocket;
    private Server server;
    private DataInputStream clientInputStream;
<<<<<<< HEAD
=======
    private String nickname = "";
>>>>>>> guessnumber
    private Prompt prompt;
    private String nickname = "";
    boolean win = false;


    private int playerChoice;
    public Menu menu = new Menu();


    private int min = 0;
    private int max = 10;
    private int player1Choice;

    private int systemNumber;


    public ClientHandler(Socket clientSocket, Server server) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            clientInputStream = new DataInputStream(clientSocket.getInputStream());
            sendToClient = new PrintStream(clientSocket.getOutputStream());
            prompt = new Prompt(clientInputStream, sendToClient);
            pickName();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pickName() {

        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Introduce yourself: ");
        String message = prompt.getUserInput(stringInputScanner);
        //this.nickname = message;

        registerClient(message, this);
        broadcast(message + " has joined the lobby.");
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }

    public void broadcast(String message) {

        System.out.println("System number: " + randomNumber(0, 10));

        for (String client : Server.hashMap.keySet()) {

<<<<<<< HEAD
        registerClient(message, this);
        System.out.println("Server number: " + server.getSystemNumber());
        broadcast(message + " has joined the lobby.");
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }

    public void broadcast(String message) {

        for (String client : Server.hashMap.keySet()) {
            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);

            while (win == false) {
                gameLogic(client);
                //metes um mathrandom numa variavel, IF um client acertar acaba o jogo
            }
        }
    }

    public void gameLogic(String client) {
        IntegerInputScanner question1 = new IntegerRangeInputScanner(server.getMin(), server.getMax());
        question1.setMessage("Pick a number: ");
        playerChoice = prompt.getUserInput(question1);
        System.out.println(client + ": " + playerChoice);

        if (playerChoice == server.getSystemNumber()) {
            broadcast(client + ", you won!");
            win = true;
            endgameMenu();
        }
    }

    public void endgameMenu() {
=======
            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);
>>>>>>> guessnumber

        String[] options = {"Back to Menu", "Play Again"};

<<<<<<< HEAD
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions(menuAnswer);
    }

    public void menuOptions(int menuAnswer) {
        switch (menuAnswer) {
            case 1:
                menu.run();
                break;
            case 2:
                System.out.println("Play Again");
                break;
        }
    }

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
    }

    public String getNickname() {
>>>>>>> guessnumber
        return this.nickname;
    }

    public int randomNumber(int min, int max) {

        // Between 0+min and (max-min+min)
        systemNumber = (int) (Math.random() * (max - min + 1) + min);

        return systemNumber;

    }

}

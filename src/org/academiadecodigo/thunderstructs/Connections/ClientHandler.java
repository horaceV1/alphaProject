package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    public PrintStream sendToClient;
    private Socket clientSocket;
    private Server server;
    private DataInputStream clientInputStream;
    private Prompt prompt;
    private String nickname = "";

    private int min = 0;
    private int max = 10;
    private int playerChoice;

    private int systemNumber = (int) (Math.random() * (max - min + 1) + min);


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

        registerClient(message, this);
        System.out.println("System number: " + systemNumber);
        broadcast(message + " has joined the lobby.");
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }

    public void broadcast(String message) {

        for (String client : Server.hashMap.keySet()) {
            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);

            while (true) {
                gameLogic(client);
                //metes um mathrandom numa variavel, IF um client acertar acaba o jogo
            }
        }
    }

    public void gameLogic(String client) {
        IntegerInputScanner question1 = new IntegerRangeInputScanner(min, max);
        question1.setMessage("Pick a number: ");
        playerChoice = prompt.getUserInput(question1);
        System.out.println(client + ": " + playerChoice);

        if (playerChoice == systemNumber) {
            broadcast(client + ", you won!");
            menu();
        }
    }

    public void menu() {

        String[] options = {"Back to Menu", "Play Again"};

        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Pick a number: ");

        int menuAnswer = prompt.getUserInput(menu);
        System.out.println("User chose: " + options[menuAnswer - 1]);

        menuOptions(menuAnswer);
    }

    public void menuOptions(int menuAnswer) {
        switch (menuAnswer) {
            case 1:
                broadcast("Back to Menu");
                break;
            case 2:
                System.out.println("Play Again");
                break;
        }
    }

    public String getNickname () {
        return this.nickname;
    }
}

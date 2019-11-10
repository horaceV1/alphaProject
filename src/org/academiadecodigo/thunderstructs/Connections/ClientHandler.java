package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.thunderstructs.Menu;

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
    private Prompt prompt;
    private String nickname = "";
    private int playerChoice;


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
        String name = prompt.getUserInput(stringInputScanner);

        registerClient(name, this);
        broadcast(getNickname() + " has joined the lobby.");

        if (Server.hashMap.size() == 0) {
            System.out.println("Server number: " + server.getSystemNumber());
        }
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }

    public void broadcast(String message) {

        for (String client : Server.hashMap.keySet()) {
            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);
            System.out.println(Server.hashMap.get(client).getNickname());

            while (!gameOver) {
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
            endgameMenu();
            broadcast(client + ", you won!");
            gameOver = true;
        }
    }

    public void endgameMenu() {


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
                menu.run();
                break;
            case 2:
                System.out.println("Play Again");
                break;
        }
    }

    public String getNickname() {
        return this.nickname;
    }
}

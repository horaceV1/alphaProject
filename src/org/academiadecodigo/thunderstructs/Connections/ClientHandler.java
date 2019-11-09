package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
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
    private String nickname = "";
    private Prompt prompt;

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

            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);


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
        return this.nickname;
    }

    public int randomNumber(int min, int max) {

        // Between 0+min and (max-min+min)
        systemNumber = (int) (Math.random() * (max - min + 1) + min);

        return systemNumber;

    }

}

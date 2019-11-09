package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
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
        this.nickname = message;

        registerClient(message, this);
        broadcast(message + " has joined the lobby.");
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        Server.hashMap.put(nickname, clientHandler);
    }

    public void broadcast(String message) {

        for (String client : Server.hashMap.keySet()) {

            System.out.println(client + ": " + message);
            Server.hashMap.get(client).sendToClient.println(message);

        }
    }

    public String getNickname() {
        return this.nickname;
    }

}

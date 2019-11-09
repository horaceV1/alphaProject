package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private Server server;
    private DataOutputStream clientOutStream;
    private DataInputStream clientInputStream;
    private int line = 0;
    private String nickname = "";
    private byte[] buffer = new byte[1024];
    private String[] args = new String[3];
    private Prompt prompt;

    public ClientHandler(Socket clientSocket, Server server) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            clientInputStream = new DataInputStream(clientSocket.getInputStream());
            clientOutStream = new DataOutputStream(clientSocket.getOutputStream());
            prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));

            getNickname();
            while ((line = clientInputStream.read(buffer)) != -1) {
                String command = new String(buffer, 0, line);
                args = command.split(" ");
                synchronized (this) {
                    server.broadcast(buffer, line, nickname);
                }
                    }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getNickname() {

        //try {

        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Introduce yourself: ");
        String message = prompt.getUserInput(stringInputScanner);

        server.registerClient(message, this);



        //if((line = clientInputStream.read(buffer)) != -1) {
        //    nickname = new String(buffer, 0, line);
        //    server.registerClient(message, this);
        //}
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }
}

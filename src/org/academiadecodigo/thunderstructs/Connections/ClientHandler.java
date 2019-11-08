package org.academiadecodigo.thunderstructs.Connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private Socket clientSocket;
    private Server server;
    private DataOutputStream clientOutStream;
    private DataInputStream clientInputStream;
    private int line = 0;
    private String nickname = "";
    private byte[] buffer = new byte[1024];
    private String[] args = new String[3];

    public ClientHandler(Socket clientSocket, Server server) {

        this.server = server;
        this.clientSocket = clientSocket;

    }

    public void run() {
        try {
            clientInputStream = new DataInputStream(clientSocket.getInputStream());
            clientOutStream = new DataOutputStream(clientSocket.getOutputStream());
            while ((line = clientInputStream.read(buffer)) != -1) {


                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

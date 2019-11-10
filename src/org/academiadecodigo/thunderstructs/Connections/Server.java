package org.academiadecodigo.thunderstructs.Connections;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private DataOutputStream sendData;
    public static HashMap<String, ClientHandler> hashMap = new HashMap<>();

    public static int counter = 0;
    private int min = 0;
    private int max = 10;
    private int systemNumber = (int) (Math.random() * (max - min + 1) + min);

    public Server(int port) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("*** Server is online ***\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server Server = new Server(8080);
        Server.start();
    }

    public void start() {

        try {

            ExecutorService clientThread = Executors.newCachedThreadPool();

            while (serverSocket.isBound()) {

                System.out.println("GameHub: Waiting for player to join...");
                Socket clientSocket = serverSocket.accept();

                ClientHandler playerHandler = new ClientHandler(clientSocket, this);
                clientThread.submit(playerHandler);

                System.out.println("A new player joined the lobby.");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSystemNumber() {
        return systemNumber;
    }
<<<<<<< HEAD

    public static HashMap<String, ClientHandler> getPlayers() {
        return hashMap;
    }

    public int getCounter(){
        return counter;
    }

    public void resetCounter(){
        this.counter = 0;
    }
=======
=======

>>>>>>> guessnumber
>>>>>>> 0e6c7ed652ec259629c96e17489e8d02eb1ff4e9
}
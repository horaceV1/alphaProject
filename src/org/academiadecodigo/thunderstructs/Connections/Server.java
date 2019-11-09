package org.academiadecodigo.thunderstructs.Connections;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private ServerSocket serverSocket;
    private DataOutputStream sendData;
    private ExecutorService clientThread = Executors.newCachedThreadPool();
    private HashMap<String, ClientHandler> hashMap = new HashMap<>();
    private Prompt prompt;

    public Server(int port) {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("*** Server is online ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server Server = new Server(8080);
        Server.start();
    }

    public void start() {

        Socket clientSocket;

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                prompt = new Prompt(clientSocket.getInputStream(), new PrintStream(clientSocket.getOutputStream()));
                clientThread.submit(new ClientHandler(clientSocket, this));
                String ip = clientSocket.getInetAddress().toString().substring(1);
                System.out.println("Welcome! " + ip);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void registerClient(String nickname, ClientHandler clientHandler) {
        hashMap.put(nickname, clientHandler);
    }

    public void broadcast(byte[] buffer, int line, String nickname) {
        System.out.println(nickname + ": " + new String(buffer, 0, line));
            for (ClientHandler key : hashMap.values()) {
                if ((key.equals(nickname))) {
                    continue;
                }

                StringInputScanner stringInputScanner = new StringInputScanner();
                stringInputScanner.setMessage(nickname + ": ");
                String message = prompt.getUserInput(stringInputScanner);

            }
    }
}
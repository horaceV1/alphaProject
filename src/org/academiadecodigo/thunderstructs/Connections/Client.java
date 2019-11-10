package org.academiadecodigo.thunderstructs.Connections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Client() {
        try {
            socket = new Socket("localhost", 8080);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        Scanner input = new Scanner(System.in);

        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {

                String message;
                while (true) {
                    try {
                        while((message = in.readLine()) != null){
                            System.out.println(message);
                        }
                    } catch (IOException e) {
                        System.err.println("Connection closed");
                        break;
                    }
                }
            }
        });

        readMessage.start();

        while (true) {
            String message = input.nextLine();
            out.println(message);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}

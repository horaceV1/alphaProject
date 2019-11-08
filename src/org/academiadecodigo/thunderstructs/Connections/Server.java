package org.academiadecodigo.thunderstructs.Connections;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT_NUMBER = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);

        while(true) {
            Socket socket = serverSocket.accept();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String info;
            while((info = bufferedReader.readLine()) != null) {
                System.out.println(info);
                if(info.equals("")) {
                    break;
                }
            }

            serverSocket.close();
            socket.close();
            bufferedOutputStream.close();
            bufferedReader.close();
        }
    }
}

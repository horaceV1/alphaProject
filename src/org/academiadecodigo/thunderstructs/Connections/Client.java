package org.academiadecodigo.thunderstructs.Connections;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

    private static final int PORT_NUMBER = 8080;

    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);

        InetAddress ip = InetAddress.getByName("localhost");

        Socket s = new Socket(ip, PORT_NUMBER);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Thread userInput = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    String msg = scn.nextLine();
                    try{
                        dos.writeUTF(msg);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try{
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        userInput.start();
        readMessage.start();
    }

    @Override
    public void run() {

    }
}

package org.greenhouse.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server_handler {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 65432;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(HOST, PORT));
            System.out.println("Server listening on " + HOST + ":" + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected by " + clientSocket.getRemoteSocketAddress());
                new Thread(new server(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
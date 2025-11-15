package org.greenhouse.server;

import java.io.*;
import java.net.Socket;

public class server implements Runnable {

    private final Socket socket;

    public server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Welcome to Smart TV TCP server. Type 'quit' to exit.");

            String command;
            while ((command = in.readLine()) != null) {
                command = command.trim();
                if (command.equalsIgnoreCase("quit")) break;
                String response = handleCommand(command);
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }

    private String handleCommand(String command) {
        return "You sent: " + command;
    }
}
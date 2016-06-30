package server;

import db.ClientDAO;
import db.DataBase;

import java.io.*;
import java.net.*;

public class Server extends Thread {
    public static final int PORT = 4325;
    private static ServerSocket server;
    protected static DataBase db;
    protected static ClientDAO clientDAO;

    public Server() {
        if (createServer()) {
            db = new DataBase();
            clientDAO = new ClientDAO(db.getConnection());
            this.start();
        }
    }

    @Override
    public void run() {
        super.run();
        connectingClient();
    }

    private void connectingClient() {

        //while (true) {
            try {
                Socket socket = server.accept();
                new WorkWithTheClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Не удалось соединиться с клиентом");
            }
        //}
    }

    private boolean createServer() {
        try {
            server = new ServerSocket(PORT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось прооиницыализировать ServerSocket с портом: " + PORT);
            return false;
        }
    }
}

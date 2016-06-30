package server;

import db.DataBase;

import java.io.IOError;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectClient extends Thread {
    public static final int PORT = 4325;
    private static ServerSocket server;
    protected static DataBase db;

    public ConnectClient() {
        if (createServer()) {
            db = new DataBase("clients");
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
                try {
                    new ServerThread(socket);
                } catch (IOError e) {
                    e.printStackTrace();
                }
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

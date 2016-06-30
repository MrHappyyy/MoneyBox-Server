package client;

import server.DataExchange;
import server.Server;

import java.io.*;
import java.net.Socket;


public class Client extends Thread {

    public Client() {
        this.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            Socket socket = new Socket("localhost", Server.PORT);
            DataExchange dataExchange = new DataExchange(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

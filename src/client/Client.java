package client;

import server.DataExchange;
import server.Server;

import java.io.*;
import java.net.Socket;


public class Client extends Thread {
    private DataExchange dataExchange;

    public Client() {
        this.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            Socket socket = new Socket("localhost", Server.PORT);
            dataExchange = new DataExchange(socket);
            authentication();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void authentication() {
        dataExchange.transferString("entrance");
        dataExchange.transferString("name1");
        dataExchange.transferString("pass1");
        System.out.println(dataExchange.acceptBoolean());
    }
}

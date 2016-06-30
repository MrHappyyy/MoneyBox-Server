package client;

import db.MoneyEntity;
import server.DataExchange;
import server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;


public class Client extends Thread {

    public Client() {
        this.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            InetAddress addr = InetAddress.getByName(null);
            Socket socket = new Socket(addr, Server.PORT);
            DataExchange dataExchange = new DataExchange(socket);
            ArrayList<MoneyEntity> l = (ArrayList<MoneyEntity>) dataExchange.acceptObject();
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

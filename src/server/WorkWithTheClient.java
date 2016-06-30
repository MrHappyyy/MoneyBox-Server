package server;

import db.MoneyEntity;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WorkWithTheClient extends Thread {
    private Socket socket;
    private DataExchange dataExchange;

    public WorkWithTheClient(Socket socket) {
        this.socket = socket;
        dataExchange = new DataExchange(socket);
        this.start();
    }

    @Override
    public void run() {
        super.run();

    }
}

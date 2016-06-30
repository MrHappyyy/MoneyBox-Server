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
        if (authentication())
            this.start();
    }

    @Override
    public void run() {
        super.run();

    }

    private boolean authentication() {
        while (true) {
            switch (dataExchange.acceptString()) {
                case "exit":
                    return false;
                case "registration":
                    if (registration())
                        return true;
                    else
                        return false;
                case "entrance":

            }
        }
    }

    private boolean registration() {

        return false;
    }
}

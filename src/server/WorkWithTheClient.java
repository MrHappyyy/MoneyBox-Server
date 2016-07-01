package server;

import db.ClientDAO;
import db.ClientEntity;
import db.MoneyEntity;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WorkWithTheClient extends Thread {
    private Socket socket;
    private DataExchange dataExchange;
    private ClientDAO clientDAO;
    private String loginClient;

    public WorkWithTheClient(Socket socket, ClientDAO clientDAO) {
        this.socket = socket;
        this.clientDAO = clientDAO;
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
                    String newName = dataExchange.acceptString();
                    String newPass = dataExchange.acceptString();
                    if (newName.equals("") || newPass.equals("")) {
                        dataExchange.transferBoolean(false);
                        dataExchange.transferString("Поля должны быть заполнены");
                    } else {
                        if (clientDAO.getByName(newName) != null) {
                            dataExchange.transferBoolean(false);
                            dataExchange.transferString("Такой логин уже занят");
                        } else if (clientDAO.getByPass(newPass) != null) {
                            dataExchange.transferBoolean(false);
                            dataExchange.transferString("Такой пароль уже занят");
                        } else {
                            clientDAO.add(new ClientEntity(newName, newPass));
                            loginClient = newName;
                            dataExchange.transferBoolean(true);
                            return true;
                        }
                    }
                    break;
                case "entrance":
                    String name = dataExchange.acceptString();
                    String pass = dataExchange.acceptString();

                    if (name.equals("") || pass.equals(""))
                        dataExchange.transferBoolean(false);
                    else {
                        ClientEntity client = clientDAO.getByName(name);

                        if (client != null) {
                            if (client.getPassword().equals(pass)) {
                                dataExchange.transferBoolean(true);
                                loginClient = name;
                                return true;
                            } else
                                dataExchange.transferBoolean(false);
                        } else
                            dataExchange.transferBoolean(false);
                    }
            }
        }
    }
}

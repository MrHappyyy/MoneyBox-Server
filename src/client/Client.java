package client;

import server.ConnectClient;

import java.io.*;
import java.net.Socket;


public class Client {

    public Client() {
        try {
            Socket socket = new Socket("localhost", ConnectClient.PORT);


            DataInput in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readUTF());
            DataOutput ou = new DataOutputStream(socket.getOutputStream());
            ou.writeUTF("Client->Server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

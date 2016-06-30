package server;

import static server.ConnectClient.*;
import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            DataOutput ou = new DataOutputStream(socket.getOutputStream());
            ou.writeUTF("Server->Client");
            DataInput in = new DataInputStream(socket.getInputStream());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

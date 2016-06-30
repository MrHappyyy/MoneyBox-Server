package server;

import java.io.*;
import java.net.Socket;

public class DataExchange {
    private Socket socket;
    private DataInput input;
    private DataOutput output;
    private ObjectInput objectInput;
    private ObjectOutput objectOutput;

    public DataExchange(Socket socket) {
        this.socket = socket;
        try {
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось создать потоки передачи через сокет");
        }
    }

    public boolean transferString(String s) {
        try {
            output.writeUTF(s);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось передать String клиенту");
            return false;
        }
    }

    public String acceptString() {
        try {
            return input.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить String с клиента");
            return "";
        }
    }

    public boolean transferInt(int i) {
        try {
            output.writeInt(i);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось передать int клиенту");
            return false;
        }
    }

    public int acceptInt() {
        try {
            return input.readInt();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить int с клиента");
            return 0;
        }
    }

    public boolean transferDouble(double d) {
        try {
            output.writeDouble(d);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось передать double клиенту");
            return false;
        }
    }

    public double acceptDouble() {
        try {
            return input.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить double с кллиента");
            return 0;
        }
    }

    public boolean transferBoolean(boolean b) {
        try {
            output.writeBoolean(b);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось передать boolean клиенту");
            return false;
        }
    }

    public boolean acceptBoolean() {
        try {
            return input.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить boolean с клиента");
            return false;
        }
    }

    public boolean transferChar(char c) {
        try {
            output.writeChar(c);
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось передать char клиенту");
            return false;
        }
    }

    public char acceptChar() {
        try {
            return input.readChar();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить char с клиента");
            return ' ';
        }
    }

    public boolean transferObject(Object o) {
        try {
            objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(o);
            objectOutput.flush();
            objectOutput.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось пердать object клиенту");
            return false;
        }
    }

    public Object acceptObject() {
        try {
            objectInput = new ObjectInputStream(socket.getInputStream());
            Object obj = objectInput.readObject();
            objectInput.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить object с клиента");
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Не удалось получить object с клиента");
            return null;
        }
    }
}

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class NewConnection implements Runnable {

    private Socket cSocket;
    private boolean online;
    int id;
    private HashMap<String, Player> players;
    private GameState gameState;
    private ObjectInputStream objectIn;
    private ObjectOutputStream objectOut;

    public NewConnection(Socket cSocket, int id) {
        this.cSocket = cSocket;
        this.id = id;
        online = true;
        try {
            objectOut = new ObjectOutputStream(cSocket.getOutputStream());
            objectIn = new ObjectInputStream(cSocket.getInputStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            do {
                Object data = objectIn.readObject();


            } while(cSocket.isConnected());
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void send(Object data) {
        try {
            objectOut.writeObject(data);
            objectOut.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try{
            objectIn.close();
            objectOut.close();
            cSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
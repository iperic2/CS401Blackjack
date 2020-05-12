import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;

public class GameClient implements Runnable{

    private String host;
    private int port;
    private Socket cSocket;
    private boolean online;
    private ObjectInputStream objectIn;
    private ObjectOutputStream objectOut;
    private int id;
    private BlackJackGUI userGUI;
    private Player player;
    private GameState gameState;

    public GameClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() {
        try {
            System.out.println("Connecting to the server...");
            cSocket = new Socket(host, port);
            objectOut = new ObjectOutputStream(cSocket.getOutputStream());
            objectIn = new ObjectInputStream(cSocket.getInputStream());
            new Thread(this).start();
            System.out.println("Player is connected");
        } catch(ConnectException e) {
            System.out.println("Connection error! Unable to connect to the server");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            online = true;
            userGUI = new BlackJackGUI();
            SwingUtilities.invokeAndWait(userGUI.startApp);
            player = userGUI.getPlayer();
            do {
                Object data = objectIn.readObject();
            } while(online);
            closeConnection();
        } catch(SocketException e) {
            closeConnection();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object packet) {
        try {
            objectOut.writeObject(packet);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            online = false;
            objectOut.close();
            objectIn.close();
            cSocket.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    void JoinGame() {

    }

}

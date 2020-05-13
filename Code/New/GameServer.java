import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class GameServer implements Runnable{

	private int port;
	private ServerSocket sSocket;
	private boolean online;
	private int numberOfPlayers;

	public GameServer(int port) {
		online = true;
		System.out.println("Game server is up and running...");
		this.port = port;
		numberOfPlayers = 0;
		try {
			sSocket = new ServerSocket(port);
			new Thread(this).start();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void acceptConnection() {
		try {
			Socket cSocket = sSocket.accept();
			numberOfPlayers++;
			// Create a new thread for the new client.
			clientConnection(cSocket);
			System.out.println(numberOfPlayers + " players have connected to the server.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void clientConnection(Socket cSocket) {
		NewConnection connection = new NewConnection(cSocket, numberOfPlayers);
		new Thread(connection).start();
	}

	public void shutdownServer() {
		try {
			sSocket.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		do {
			acceptConnection();
		} while(online);
		shutdownServer();
	}

	public static void main(String[] args) {
		GameServer gameServer = new GameServer(18888);
		gameServer.acceptConnection();
	}
}

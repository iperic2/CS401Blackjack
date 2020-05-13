import java.util.Vector;
import java.util.Scanner;

public class BlackJackDriver
{
	public static void main(String[] args) throws InterruptedException {
		GameClient client = new GameClient("localhost", 18888);
		client.connect();
		/*Thread.sleep(3000);
		GameClient client2 = new GameClient("localhost", 18888);
		client2.connect();
		Thread.sleep(3000);
		GameClient client3 = new GameClient("localhost", 18888);
		client3.connect();*/
	}
}
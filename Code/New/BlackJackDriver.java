import java.util.Vector;
import java.util.Scanner;

public class BlackJackDriver
{
	public static void main(String[] args)
	{
		BlackJackGUI frame = new BlackJackGUI();
		frame.profile();

		/*Scanner scan = new Scanner(System.in);
		
		System.out.println("How many players?");
		int playerNum = scan.nextInt();
		
		
		Vector<Player> players = new Vector<>();
		players.add(new Player("Alex", "abc", new Balance(2500, true)));
		Dealer dealer = new Dealer();
		Game game = new Game(dealer, players, playerNum);
		game.newTable();

		Vector<Card>cards = new Vector<>();
		cards.add(new Card(Suit.SPADE, Rank.ACE, Rank.ACE.getValue()));
		cards.add(new Card(Suit.SPADE, Rank.EIGHT, Rank.EIGHT.getValue()));
		cards.add(new Card(Suit.SPADE, Rank.TWO, Rank.TWO.getValue()));
		cards.add(new Card(Suit.HEART, Rank.ACE, Rank.ACE.getValue()));
		cards.add(new Card(Suit.CLUB, Rank.ACE, Rank.ACE.getValue()));
		cards.add(new Card(Suit.DIAMOND, Rank.ACE, Rank.ACE.getValue()));
		Hand hand = new Hand(cards);
		System.out.println(hand.handValue());*/
	}
}
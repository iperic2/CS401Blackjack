import java.util.Vector;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

public class Game
{
	private Deck deck;
	private Dealer dealer;
	private Vector<Player> players;
	private Vector<Hand> hands;
	private Rules rules;
	private Scanner input;
	private final static int vectorSize = 6;
	// number of players
	private int numPlayer;

	public Game(int numPlayer) {
		dealer = new Dealer();
		players = new Vector<>();
		hands = new Vector<>();
		this.numPlayer = numPlayer;
	}

	public Game(Dealer dealer, Vector<Player> players, int numPlayer) {
		this.dealer = dealer;
		this.players = players;
		this.numPlayer = numPlayer;
		this.hands = new Vector<>();
		this.input = new Scanner(System.in);
	}

	public void newGame() {
		deck = new Deck();
		deck.shuffleDeck();
		cardsDistribution();
	}

	public void hit() {
		hands.elementAt(0).addCard(deck.distributeCard());
	}

	public void cardsDistribution() {
		for(int i = 0, j = 0; i < (numPlayer + 1) * 2; i++) {
			if(i < numPlayer + 1)
				hands.add(deck.initHand());
			else
				hands.elementAt(j++).addCard(deck.distributeCard());
		}
	}

	// Console debugging purpose
	public void displayHand() {
		System.out.println("Dealer Current Hand: " + hands.elementAt(hands.size() - 1).dealerCard() + " [Face Down]");
		System.out.println("Dealer Current Value: " + hands.elementAt(hands.size() - 1).dealerValue() + '\n');
		for(int i = 0; i < hands.size() - 1; ++i) {
			System.out.println("Player: " + players.elementAt(i).getUsername());
			System.out.println("Current Hand: " + hands.elementAt(i).toString());
			System.out.println("Current Value: " + hands.elementAt(i).handValue() + '\n');
		}
	}

	// Console Debugging purpose
	public void displayFinalResult() {
		System.out.println("Dealer Final Hand: " + hands.elementAt(hands.size() - 1).toString());
		System.out.println("Dealer Final Value: " + hands.elementAt(hands.size() - 1).handValue() + '\n');
		for(int i = 0; i < hands.size() - 1; ++i) {
			System.out.println("Player: " + players.elementAt(i).getUsername());
			System.out.println("Final Hand: " + hands.elementAt(i).toString());
			System.out.println("Final Value: " + hands.elementAt(i).handValue() + '\n');
		}
	}

	public void dealerDraw() {
			hands.elementAt(1).addCard(deck.distributeCard());
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	// return number of players
	public int getPlayer()
	{
		return numPlayer;
	}

	public Hand getDealerHand() {
		return hands.elementAt(hands.size() - 1);
	}

	public Hand getPlayerHand() {
		return hands.elementAt(0);
	}

	// reset game
	public void reset()
	{
		
	}

	static int interval;
	static Timer timer;
	
	// countdown
	public void countdown()
	{
		int delay = 1000;
		int period = 1000;
		int seconds = 10;
		timer = new Timer();
		interval = seconds;
		System.out.println(seconds);
		timer.scheduleAtFixedRate(new TimerTask()
			{	
	        	public void run()
	        	{
	        		System.out.println(setInterval());
	        	}
			}, delay, period);
	}
	
	// because countdown needs to literally count down.
	private static final int setInterval()
	{
		if (interval == 1)
		timer.cancel();

		return --interval;
	}
}
import java.util.Vector;
import java.util.Scanner;
import java.math.BigDecimal;

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

	public Game(Dealer dealer, Vector<Player> players, int numPlayer) {
		this.dealer = dealer;
		this.players = players;
		this.numPlayer = numPlayer;
		this.hands = new Vector<>();
		this.input = new Scanner(System.in);
	}

	public void newTable() {
		System.out.println("Welcome to CS401 Blackjack");
		int nextGame = 1;
		do {
			deck = new Deck();
			deck.shuffleDeck();
			/*System.out.println("The game will start in 10 seconds.\nPlace your bet: ");
			new WaitTime();*/
			System.out.println("Place your bet: ");
			BigDecimal bet = input.nextBigDecimal();
			cardsDistribution();
			displayHand();
			int option = 0;
			do {
				System.out.println("Enter 0 for stand and 1 for hit");
				option = input.nextInt();
				if(option == 1) {
					hands.elementAt(0).addCard(deck.distributeCard());
					displayHand();
				}
			} while(option != 0 && !hands.elementAt(0).isBust());
			/*new WaitTime();
			System.out.println("Enter 0 to quit or the next game will start in 10 seconds.");*/
			dealerDraw();
			displayFinalResult();
			rules = new Rules(hands.elementAt(1).handValue(), hands.elementAt(0).handValue());
			if(rules.gameOutcome() == 0) {
				System.out.println("It is a draw.");
				bet = BigDecimal.valueOf(0);
			}
			else if(hands.elementAt(0).isBust() || rules.gameOutcome() == 1) {
				System.out.println("Dealer won.");
				bet = bet.multiply(new BigDecimal(-1));
			}
			else
				System.out.println("Player won.");
			players.elementAt(0).setBalance(bet);
			System.out.println("\nCurrent balance: " + players.elementAt(0).getBalance());
			System.out.println("\nEnter 0 to quit and any key to the next game.");
			nextGame = input.nextInt();
			/*if(nextGame == 0)
				numPlayer = 0;
		} while(numPlayer > 0);*/
		} while(nextGame != 0);
	}

	public void cardsDistribution() {
		for(int i = 0, j = 0; i < (numPlayer + 1) * 2; i++) {
			if(i < numPlayer + 1)
				hands.add(deck.initHand());
			else
				hands.elementAt(j++).addCard(deck.distributeCard());
		}
	}

	public void displayHand() {
		System.out.println("Dealer Current Hand: " + hands.elementAt(hands.size() - 1).dealerCard() + " [Face Down]");
		System.out.println("Dealer Current Value: " + hands.elementAt(hands.size() - 1).dealerValue() + '\n');
		for(int i = 0; i < hands.size() - 1; ++i) {
			System.out.println("Player: " + players.elementAt(i).getUsername());
			System.out.println("Current Hand: " + hands.elementAt(i).toString());
			System.out.println("Current Value: " + hands.elementAt(i).handValue() + '\n');
		}
	}

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
		while(hands.elementAt(1).handValue() < hands.elementAt(0).handValue() && hands.elementAt(1).handValue() < 22) {
			System.out.println("Dealer is drawing...");
			hands.elementAt(1).addCard(deck.distributeCard());
		}
	}

	public void setNumPlayer(int numPlayer) {
		this.numPlayer = numPlayer;
	}

	// return number of players
	public int getPlayer()
	{
		return numPlayer;
	}

	// reset game
	public void reset()
	{
		
	}

	// countdown
	public void countdown()
	{

	}
}

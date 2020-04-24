import java.util.Collections;
import java.util.Arrays;
import java.util.Vector;

public class Deck {

	private Card[] cards;
	private final static int arraySize = 52;
	private int currentIndex;

	public Deck() {
		cards = new Card[arraySize];
		currentIndex = 0;
		newDeck();
	}

	public void newDeck() {
		currentIndex = 0;
		int i = 0;
		for(Suit suit: Suit.values())
			for(Rank rank: Rank.values())
					cards[i++] = new Card(suit, rank, rank.getValue());
	}

	public void shuffleDeck() {
		Collections.shuffle(Arrays.asList(cards));
	}

	public Hand initHand() {
		Hand hand = new Hand();
		hand.addCard(cards[currentIndex++]);
		return hand;
	}

	public Card distributeCard() {
		return cards[currentIndex++];
	}

	public String toString() {
		String allCards = "";
		for(Card card : cards)
			allCards += card.toString();
		return allCards;
	}

	public void getCard(Card c) {
		//pre-condition: users has no card in hand
		//post-condition: users get two card randomly in hand
	}
	
	Card drawCard(Card c) {
		//pre-condition: total value of cards in user's hand does not exceed 21
		//post-condition: adds a new card to the player
		return c;
	}
	
	
	public void stopDraw() {
		//pre-condition: users decide to stop adding card to hand
		//post-condition: no more card is added to user hand
	}
	
	public void displayFrontSide() {
		//pre-condition: two Cards are passed out
		//post-condition: Shows the values of a card based on user decision
	}
	
	public void displayBackSide() {
		//pre-condition: two cards are passed out
		//post-condition: Shows back side of card to all users except the player
	}
	
	public void Shuffle(Deck d) {
		//pre-condition: Receives a deck of 52 cards
		//post-condition: randomizes order of the deck
	}

}

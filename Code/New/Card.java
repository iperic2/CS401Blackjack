public class Card {

	private Suit suit;
	private	Rank rank;
	private	int value;

	public Card() {
		suit = null;
		rank = null;
		value = 0;
	}

	public Card(Suit suit, Rank rank, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		return suit.toString() + " - " + rank.toString();
	}
}


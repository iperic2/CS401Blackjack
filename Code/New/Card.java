public class Card {

	private String suit;
	private	String rank;
	private	int value;

	public Card() {
		suit = "";
		rank = "";
		value = 0;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}

}


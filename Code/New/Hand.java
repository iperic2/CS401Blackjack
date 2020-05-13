import java.util.Vector;
import java.util.Collections;
import java.util.Comparator;


public class Hand
{
	// hand full of cards
	private Vector<Card> hand;

	public Hand() {
	    hand = new Vector<>();
    }

    public Hand(Vector<Card> hand) {
        this.hand = hand;
    }

    // return hand value
	public int handValue()
	{
		Vector<Card> temp = new Vector<>();
		temp = hand;
		Comparator c = Collections.reverseOrder(new SortHandDescending());
		Collections.sort(temp, c);
	    int value = 0;
        for(int i = 0; i < temp.size(); ++i) {
        	if(temp.get(i).getRank() == Rank.ACE && value < 10)
        		value += 11;
        	else
            	value += temp.get(i).getValue();
        }
        return value;
	}

	public class SortHandDescending implements Comparator<Card> {
		public int compare(Card a, Card b) {
			return a.getValue() - b.getValue();
		}
	}

	// draw card
	public void addCard(Card card)
	{
		hand.add(card);
	}

	// checks if hand is blackjack
	public boolean isBlackJack()
	{
        return handValue() == 21;
	}

	// check if hand is bust
	public boolean isBust()
	{
        return handValue() > 21;
	}

	public String dealerCard() {
		return hand.elementAt(0).toString();
	}

	public int dealerValue() {
		return hand.elementAt(0).getValue();
	}

	public String toString() {
		String cards = "";
		for(int i = 0; i < hand.size(); ++i)
			cards += hand.elementAt(i).toString();
		return cards;
	}

	public Card getCard(int index) {
		return hand.elementAt(index);
	}

}


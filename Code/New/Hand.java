public class Hand
{
	// hand full of cards
	private Card[] hand;

	public Hand() {
	    hand = new Card[0];
    }

    public Hand(Card[] hand) {
        this.hand = hand;
    }

    // return hand value
	public int handValue()
	{
	    int value = 0;
        for(int i = 0; i < hand.length; ++i) {
            value += hand[i].getValue();
        }
        return value;
	}

	// draw card
	public void drawCard()
	{

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
}

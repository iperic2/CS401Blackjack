public class Rules
{

	private int dealerHandValue;
	private int playerHandValue;

	public Rules(int dValue, int pValue) {
		dealerHandValue = dValue;
		playerHandValue = pValue;
	}

	// decide outcome of game
	public int gameOutcome()
	{
		if(dealerHandValue == playerHandValue)
			return 0;
		else if(dealerHandValue < 22 && dealerHandValue > playerHandValue)
			return 1;
		else
			return 2;
	}
}
